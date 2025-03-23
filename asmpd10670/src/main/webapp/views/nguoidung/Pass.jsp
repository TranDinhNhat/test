<%@page import="fpt.dao.UserDao"%>
<%@page import="fpt.entity.User"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Đổi Mật Khẩu</title>
</head>
<body>
<div class="full-height d-flex bg-light" style="justify-content: center;
    align-items: center;
    min-height:100vh;">
    <div class="border" style="border-radius: 12px; box-shadow: 0px 2px 15px;">
    <div class="container p-3" style="width: 500px;">
     
     	<h2 class="text-center">Đổi mật khẩu</h2>
        <form action="${pageContext.request.contextPath}/DoiPass/admin" method="post" class="form-bordered was-validated p-2">
 			 
           <input type="text" name="id"  > <br>
           
           <input class="form-control p-3 " name = "email" type="hidden"  placeholder="Nhập email của bạn" required>
		<br>
		
           <input type="password" name="password"  placeholder="Mật khẩu mới" class="form-control p-2 m-2"> <br>
           
           <input type="password" name="password" placeholder="Xác nhận mật khẩu" class="form-control p-2 m-2"> <br>
           
           <input class="form-control p-3 " type="hidden"   name="fullname" placeholder="Nhập tên đầy đủ của bạn" required>
		<br>
           
           <input type="hidden" value="0" name="admin">
           
           <input type="submit" value="Đổi mật khẩu">
           
        </form>
  
    </div>
     </div>
</div>
</body>
</html>