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
<title>Quản Lý Người Dùng_Create</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
	<h2>Thêm tài khoản</h2>
	 <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message" style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
	<form class="form-bordered was-validated" action="/asmpd10670/User/create" method="post">
		<label class="form-label">Mã Người Dùng</label>
			<input class="form-control" type="text"  name = "id" required>	
			<br>
		<label class="form-label">PassWord</label>
			<input class="form-control" type="password"   name="password" required>
			<br>
		<label class="form-label">Email</label>
			<input class="form-control" type="email"  name="email" required>
			<br>
		<label class="form-label">Fullname</label>
			<input class="form-control" type="text"   name = "fullname" required>
			<br>
		<label class="form-label">Role</label>
			<select id ="admin" name = "admin" required>
				<option value= "0" >Người dùng</option>
				<option value= "1" >Quản Trị</option>
			</select>
			<br>
			<hr>
			<input type="submit"class="form-bordered text-light bg-primary p-1"
			style="border:12px soli blue; border-radius:10px;
			text-decoration: none;" value="Thêm tài khoản">
			<a href="/asmpd10670/User" class="form-bordered text-light bg-primary p-2"
			style="border:12px soli; border-radius:10px;
			text-decoration: none;">Danh Sách Người Dùng</a>
	</form>
</div>
</div>
</body>
</html>