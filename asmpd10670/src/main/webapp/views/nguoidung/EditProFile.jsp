<%@page import="fpt.entity.User"%>
<%@page import="java.util.List"%>
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
<title>Chỉnh sửa thông tin cá nhân</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
	<form action="${pageContext.request.contextPath }/ProFile/nguoidung/edit" method="post">
		<%
			List<User> userList = (List<User>) request.getAttribute("userProFile");
			for(User user : userList){
		%>
		<input class="form-control" value="<%=user.getId() %>" type="text" name="id">
		<br>
		<input class="form-control" value="<%=user.getPassword() %>" type="password" name="password">
		<br>
		<input class="form-control" value="<%=user.getEmail()%>"type="email" name="email">
		<br>
		<input class="form-control" value="<%=user.getFullname() %>" type="text" name="fullname">
		<br>
		<input class="form-control" value="0" name="admin" readonly="readonly">
		<br>
		<%} %>
		<input type="submit" class="form-control" value="Đổi Thông Tin"> 
		
	</form>
</div>
</body>
</html>