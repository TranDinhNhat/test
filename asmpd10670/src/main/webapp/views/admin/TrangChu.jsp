<%@page import="fpt.entity.Favorite"%>
<%@page import="java.util.List"%>
<%@page import="fpt.dao.VideoDao"%>
<%@page import="fpt.entity.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Trang Chủ</title>
</head>

<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>

<div style="padding-top: 40px; padding-left: 350px;">
      <h2>Welcome, Admin</h2>
    <div class="content">
        <div class="row">
            <%
                VideoDao dao = new VideoDao();
                List<Video> videoList = dao.findAll();
                for (Video video : videoList) {
            %>
            <div class="col-md-4 p-3">
                <div class="video-car" style="width: 400px; border-radius: 15px;">
                    <div class="poster item-center text-center"> 
                        <a href="/asmpd10670/Video/admin/view?id=<%=video.getId() %>">
                            <video width="300" height="180"  style="border-radius: 10px;"
                                poster="/asmpd10670/images/<%=video.getPoster()%>">
                                <source src="/asmpd10670/images/<%=video.getPoster()%>" type="video/mp4">
                                Trình duyệt của bạn không hỗ trợ thẻ video.
                            </video>
                        </a>
                    </div>
                    <h6><%=video.getTitle() %></h6>
                    <div class="d-flex">
                        <div class="m-2 d-flex">
                            <span class="d-flex"><%=video.getViews() %><p style="padding-left: 5px;">Lượt xem</p></span>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>

</body>
</html>
