<%@page import="java.util.List"%>
<%@page import="fpt.entity.Video"%>
<%@page import="fpt.dao.VideoDao"%>
<%@page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<meta charset="UTF-8">
<title>Trang Chủ</title>
</head>
<style>
.like:hover, .share:hover {
    background-color: black;
    color: white;
    transform: scale(1.1);
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
}
</style>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px; overflow-x: hidden;">
<%
    String id = request.getParameter("id");
    VideoDao dao = new VideoDao();
    Video video = dao.findById(id);
%>

<div class="d-flex">
    <div class="video" style="margin-bottom: 50px">
        <video width="1500px" height="700px" controls style="border-radius: 15px;">
            <source src="/asmpd10670/images/<%=video.getPoster()%>" type="video/mp4">
            Trình duyệt của bạn không hỗ trợ video.
        </video>
        <h2><%=video.getTitle() %></h2>
        <hr>
        <div class="d-flex">
            <div style="padding-right: 15px;">
                <form action="${pageContext.request.contextPath}/Video/admin/like" method="post" style="display: inline;">
                    <input type="hidden" name="videoId" value="<%=video.getId()%>">
                    <button class="like" style="border:none; border-radius: 10px; width: 60px; height: 40px;" type="submit">Like</button>
                </form>
            </div>
            <div>
                <button class="share" style="border:none; border-radius: 10px; width: 60px; height: 40px;">Share</button>
            </div>
            <div style="padding-left: 750px">
                <%=video.getViews() %> Lượt xem
            </div>
        </div>
    </div>
</div>

<div class="row" style="padding-left: 20px;">
<%
    int count = 0;
    VideoDao dao2 = new VideoDao();
    List<Video> videolist = dao2.findAll();
    Collections.shuffle(videolist);
    for(Video videoList : videolist){
        if(videoList.isActive() && count < 10){
%>
    <div class="col-sm-12 d-flex" style="height: 160px;">
        <a href="/asmpd10670/Video/admin/view?id=<%=videoList.getId()%>">
            <video width="250px" height="155px" style="border-radius: 15px; padding-bottom: 10px;" controls
                poster="/asmpd10670/images/<%=videoList.getPoster()%>">
                <source src="/asmpd10670/images/<%=videoList.getPoster()%>" type="video/mp4">
                Trình duyệt của bạn không hỗ trợ video.
            </video>
        </a>
        <div style="padding-left: 15px;">
            <h6 style="width: 200px;"><%=videoList.getTitle() %></h6>
            <span class="d-flex"><%=videoList.getViews() %><p style="padding-left: 5px;">Lượt xem</p></span>
        </div>
    </div>
<%
        count++;
        }
    }
%>
</div>

</div>
</body>
</html>
