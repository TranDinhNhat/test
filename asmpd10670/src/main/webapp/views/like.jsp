<%@page import="fpt.entity.Favorite"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Favorite> favorite = (List<Favorite>)request.getAttribute("favorite");
	for(Favorite favoriteid: favorite){
		
	
%>
	<form action="">
		<input value="<%=favoriteid.getVideo().getId()%>">
		<input value="<%=favoriteid.getUser().getId()%>">
		<input value="<%=favoriteid.getVideo().getTitle()%>">
		<input value="<%=favoriteid.getLikedate()%>"> 
	</form>
<%}
	%>
</body>
</html>