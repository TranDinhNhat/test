<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fpt.entity.User" %>
<%@ page import="java.sql.ResultSet" %>
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
<title>Trang quản lý người dùng</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
	<h2 style="font-family: roboto">Danh Sách Người Dùng</h2>
	<a href="/asmpd10670/User/create" > <button class="text-light bg-primary" style="border:12px soli; border-radius:10px;">Thêm người dùng</button> </a>
	<hr>
	<div style="margin-bottom: 20px">
    <form action="/asmpd10670/User/search" method="get" class="form-bordered p-2">
        <input type="text" name="query" placeholder="Nhập từ khóa tìm kiếm..." required 
        style="border:12px soli; border-radius:10px;">
        <input type="submit" value="Tìm Kiếm"class="form-bordered text-light bg-primary"
        style="border:12px soli; border-radius:10px;">
    </form>
</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Mã đăng nhập</th>
				<th>Mật khẩu</th>
				<th>Email</th>
				<th>Họ Và Tên</th>
				<th>Vai trò</th>
				<th>Sửa thông tin</th>
				<th>Xóa người dùng</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items = "${userList}">
			<tr>
			<td>${item.id}</td>
			<td>${item.password }</td>
			<td>${item.email }</td>
			<td>${item.fullname }</td>
			<td> 
				<c:choose>
					<c:when test="${item.admin == 0}">Người Dùng</c:when>
					<c:when test="${item.admin == 1 }">Quản Trị</c:when>
				</c:choose>
			</td>
			<td>
				<a class="text-light bg-primary btn-action btn-edit nav-link"
					    style="border:12px soli; border-radius:10px" href="${pageContext.request.contextPath}/User/update?id=${item.id}">
					     Chỉnh Sửa Thông Tin 
					</a>
			</td>
			<td> <form action="/asmpd10670/User/delete" method="post">
					<input class="form-control"	name="id" value="${item.id }" type="hidden">
					<button class="text-light bg-primary btn-action btn-delete" onclick= "return confirm('Bạn có chắc chắn muốn xóa người dùng này');" 
					style="border:12px soli;border-radius:12px;" type="submit">Xóa Người Dùng</button>	
					</form> 
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
</div>
</body>
</html>