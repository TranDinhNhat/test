<%@page import="java.util.List"%>
<%@page import="fpt.entity.User"%>
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
<title>Trang Thông Tin Cá Nhân</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-8 border" style="box-shadow: 0px 5px 10px; border-radius: 10px;">
	<h2>Thông tin cá nhân của bạn</h2>
	</div>
	<div class="col-sm-3"></div>
	</div>
	<div class="row" style="padding-top: 10px;">
	<div class="col-sm-1"></div>
	<div class="col-sm-8" >
		<div class="p-2" style="border-radius: 10px; box-shadow: 0px 5px 10px;">
			<%
				List<User> userList = (List<User>)request.getAttribute("userProFile");
				for(User user : userList){
			%>
			<input class="form-control" value="<%=user.getId()%>" readonly="readonly">
			<br>
			<input class="form-control" value="<%=user.getPassword()%>" readonly="readonly">
			<br>
			<input class="form-control" value="<%=user.getEmail()%>" readonly="readonly">
			<br>
			<input class="form-control" value="<%=user.getFullname()%>" readonly="readonly">
			<br>
 
			<%} %>
			<a class="border nav-link" style="width: 200px; text-align: center; border-radius: 10px;" href="/asmpd10670/ProFile/nguoidung/edit"> 
				Đổi thông tin
			</a>
		</div>
		
	</div>
	<div class="col-sm-3"></div>
	</div>
	</div>
</body>
</html>