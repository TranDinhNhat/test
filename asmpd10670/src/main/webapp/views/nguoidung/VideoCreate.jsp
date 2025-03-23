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
<title>Thêm Video</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-nguoidung.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
	<h1>Đăng Video</h1>
	 <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message" style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <form class="form-bordered was-validated" action="/asmpd10670/Video/nguoidung/create" method="post" enctype="multipart/form-data">
        	<div class="border p-3" style="border-radius: 12px;">
        	<div class=" d-flex">
        	<div class="border" style="">
        	<div style="padding: 90px;">
        	<input class="form-control"  type="file" name="ava" required>
        	</div>
        	</div>
        	
        	<div style="padding-left: 30px;">
        	<label class="form-label">Mã Video</label><br>
        	<input class="form-control" type="text" name="id" placeholder="Mã Video" required>
        	<br>
        	<label class="form-label">Tiêu Đề</label><br>
        	<input class="form-control" type="text" name="title" placeholder="Tiêu Đề Của Video" required>
        	<br>
        	<label class="form-label">Trạng Thái: </label>
        	<input class="" type="radio" name="active" value="Đang Hoạt Động" required><b class="p-2">Đang Hoạt Động</b>  
        	<input class="" type="radio" name="active" value="Chưa Hoạt Động" required><b class="p-2">Chưa Hoạt Động</b>
        	<br>
        	</div>
        	
        	</div>
        	
    
        	
        	<br>
        	<label class="form-label">Lượt Xem</label><br>
        	<input class="form-control" type="number" name="views" value="0" readonly>
        	<br>
        	<label class="form-label">Nội Dung</label><br>
        	<input class="form-control" type="text" placeholder="Nội Dung Video Này" name="description" required>
        	<br>
        	
        	<input type="submit" value="Up Video">
        	</div>
        </form>
</div>
</div>
</body>
</html>