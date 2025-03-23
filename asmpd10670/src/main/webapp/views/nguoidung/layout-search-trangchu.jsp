<%@page import="java.util.List"%>
<%@page import="fpt.dao.VideoDao"%>
<%@page import="fpt.entity.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-nguoidung.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
	<%
	String query = request.getParameter("query");
	if(query != null && !query.trim().isEmpty()){
	VideoDao dao = new	VideoDao();
	List<Video> videoList = dao.searchByKeyWord(query);
	for(Video video : videoList){
	%>
	<div class="p-3 d-flex">
	
	<div class="img">
	<a href="/asmpd10670/Video/nguoidung/detall?id=<%=video.getId()%>">
		<img alt="" src="/asmpd10670/images/<%=video.getPoster()%>" width="250px"></a>
		</div>
		
		<div class="content" style="padding-left: 10px;">
		<h5><%=video.getTitle() %></h5>
		<p><%=video.getDescription() %></p>
		<br>
		<div class="d-flex">
		<span><%=video.getViews() %></span>
		<p style="padding-left: 10px;">lượt xem</p>
		</div>
		</div>
	</div>
	<% }
	if(videoList.isEmpty()){%>
	<p>Không tìm thấy video nào khớp với từ khóa</p>
	<%}
	} %>
</div>
</div>
</body>
</html>