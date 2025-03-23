<%@page import="javax.naming.spi.DirStateFactory.Result"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<title>Tìm kiếm video</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
	<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Mã Video</th>
					<th>Tiêu Đề</th>
					<th>Hình Ảnh</th>
					<th>Lượt Xem</th>
					<th>Nội dung</th>
					<th>Trạng thái</th>
				</tr>
			</thead>
		
				<%String query = request.getParameter("query");
				if(query != null && !query.trim().isEmpty()){
				VideoDao dao = new VideoDao();
				List<Video> videoList = dao.findAll();
				for(Video video : videoList){
				%>
				<tbody>
				<tr>
					<td><%=video.getId() %></td>
					<td><%=video.getTitle() %></td>
					<td><%=video.getViews() %></td>
					<td><%=video.getDescription() %></td>
					<td><%=video.isActive() %></td>
				</tr>
			</tbody>
			<%} 
			if(videoList.isEmpty()){
			%>
			<p>Không tìm thấy video nào khớp với từ khoá của bạn!</p>
			<br>
			<a href="/asmpd10670/Video/admin" class="form-bordered text-light bg-primary p-2"
			style="border:12px soli; border-radius:10px;">Quay Lại</a>
			<%} 
			
			}
			%>
			
		</table>
	</div>	
	</div>
</body>
</html>