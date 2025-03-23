<%@page import="fpt.entity.Share"%>
<%@page import="java.util.List"%>
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

<title>Bài Viết Đã Chia Sẻ</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
<h4 class="text-dark" style="font-family: roboto">Danh Sách Người dùng đã chia sẻ Video</h4>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>STT</th>
			<th>Họ Và Tên</th>
			<th>Tiêu Đề Video</th>
			<th>Emaill</th>
			<th>Ngày Chia Sẻ</th>
			<th>Hành Động</th>
		</tr>
	</thead>
	
	<tbody>
	<%
	List<Share> shareList = (List<Share>)request.getAttribute("shareList");
	for(Share share : shareList){
	%>
		<tr>
			<td><%=share.getId() %></td>
			<td><%=share.getUser().getFullname() %></td>
			<td><%=share.getVideo().getTitle() %></td>
			<td><%=share.getUser().getEmail() %></td>
			<td><%=share.getSharedate() %></td>
			<td>
				<form action="/asmpd10670/Share/admin/delete" method="post">
						<input class="form-control" name="id" value="<%= share.getId() %>" type="hidden">
						<button class="text-light bg-primary btn-action btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa?')"
						style="border:12px soli; border-radius:10px;">Xóa video đã thích</button>
					</form>
			</td>
		</tr>
		<%}
	%>	
	</tbody>
	
</table>
</div>
</div>
</body>
</html>