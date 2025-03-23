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

<title>Đăng Kí Tài Khoản</title>
 
</head>
 
<body>
<div class="full-height d-flex" style="justify-content: center; align-items: center; min-height:100vh;">
 <div class="content">
 
<div class=" border" style="width: 500px;
									border-radius: 8px;
									padding: 40px;
									box-shadow: 0px 2px 10px">
 	<div class="text-center"> 
 	<h3 style="margin-bottom: 50px">Tạo Tài Khoản Mới</h3>
 	</div>
 	<c:if test="${not empty errorMessage}">
 		<p>${errorMessage}</p>
 	</c:if>
	<form action="/asmpd10670/dangki" method="post" class="form-bordered">

		<input class="form-control p-3 " name = "id" type="text" placeholder="Tên đăng nhập"  required="required"> 
		<br>

		<input class="form-control p-3 " name = "email" type="email" placeholder="Nhập email của bạn" required="required">
		<br>

		<input class="form-control p-3 " type="password" name="password" placeholder="Nhập mật khẩu của bạn" required="required">
		<br>

		<input class="form-control p-3 " type="text" name="fullname" placeholder="Nhập tên đầy đủ của bạn"  required="required">
		<br>

		<input type="hidden" value="0" name="admin">
		<br>
		<input class="text-light bg-primary" type="submit"value="Đăng kí tài khoản"
			style="border:12px soli; 
			border-radius:10px;
			width: 100%;
			height: 50px;">
		<hr>
  

		 <a href="/asmpd10670/login" class="nav-link text-primary p-1 mt-2  "
		>Bạn đã có tài khoản ư?</a>
 
	</form>
</div>
</div>
</div>
</body>
</html>