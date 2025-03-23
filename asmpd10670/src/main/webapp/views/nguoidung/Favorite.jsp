<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="fpt.entity.Favorite" %>
     <%@page import="java.util.List"%>
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

<title> Video Yêu Thích</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-nguoidung.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
<form action="/asmpd10670/Favorite/admin/search" method="get" class="form-bordered p-2">
        <input type="text" name="query" placeholder="Nhập từ khóa tìm kiếm..." required 
        style="border:12px soli; border-radius:10px;">
        <input type="submit" value="Tìm Kiếm"class="form-bordered text-light bg-primary"
        style="border:12px soli; border-radius:10px;">
    </form>
    <h3 class="text-info">Danh sách người dùng đã like Video</h3>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Mã Video</th>
			<th>Tên Người Dùng </th>
			<th>Tiêu Đề </th>
			<th>Thời Gian </th>
			<th>Xóa video khỏi danh sách thích </th>
		</tr>
	</thead>
	<tbody>
			<%
            List<Favorite> favoriteList = (List<Favorite>) request.getAttribute("findUser");
            for (Favorite favorite : favoriteList) {
        %>
			<tr>
				<td><%= favorite.getId()  %></td>
				<td><%= favorite.getUser().getFullname() %></td>
				<td><%= favorite.getVideo().getTitle() %></td>
				<td><%= favorite.getLikedate() %></td>
				<td>
					<form action="/asmpd10670/Favorite/admin/delete" method="post">
						<input class="form-control" name="id" value="<%= favorite.getId() %>" type="hidden">
						<button class="text-light bg-primary btn-action btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa video này?')"
						style="border:12px soli; border-radius:10px;">Xóa video đã thích</button>
					</form>
				</td>
				
			</tr>
			<% }%>
	</tbody>
</table>
</div>
</div>
</body>
</html>