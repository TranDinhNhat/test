<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Login</title>
</head>
 
<body>

<div class="full-height d-flex" style="justify-content: center;
        align-items: center;
        min-height: 100vh; "> 
        <div class="content">
         
<div class="border"  
	style=" width: 500px;
		border-radius: 8px;	
		box-shadow:  0 2px 10px;
		padding: 40px;">
 	<h3 class="text-center">Đăng Nhập Tài Khoản</h3>
<% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
	<form class="form-bordered  text-center" action="/asmpd10670/login" method="post">
		<br>
		<input class="form-control p-3 " type="text" name="id" placeholder="Tên đăng nhập của bạn" >
		<br>

		<br>
		<input class="form-control p-3 " type="password" name = "password" placeholder="Mật khẩu đăng nhập" >
		<br>
		<hr>
		
		<input class="text-light bg-primary fomr-control" type="submit" 
		style="border: none; border-radius:10px; width: 100%; height: 50px; "
		value="Đăng Nhập">
		<div class="p-3">
		<a href="" class="text-dark" style="text-decoration: none;">Quên mật khẩu?</a>
		</div>
		<hr>
	</form>
	<p class="mt-2">
		Bạn chưa có tài khoản? <a class="form-bordered text-light bg-primary p-2" href="/asmpd10670/dangki"
		style="text-decoration:none; 
		border:12px soli; 
		border-radius:10px;">Tạo Tài Khoản Mới </a>
	</p>
</div>
</div>
 </div>
</body>
</html>