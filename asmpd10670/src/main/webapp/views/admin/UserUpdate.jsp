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
<title>Quản Lý Người Dùng</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
	<h2>Chỉnh sửa thông tin nguời dùng</h2>
	<form class="form-bordered" action="${pageContext.request.contextPath}/User/update" method="post">
		<input type="hidden" name="id" value="${userupdate.id}">
		<label class="form-label">PassWord</label> <br>
		<input type="password" name="password" value="${userupdate.password }" required="required">
		<br>
		<label class="form-label">Email</label> <br>
		<input class="form-control" type="email" name="email" value="${userupdate.email }" required="required">
		<br>
		<label class="form-label">FullName</label><br>
		<input class="form-control" type="text" name="fullname" value="${userupdate.fullname }" required="required">
		<br>
		<label class="form-label">Role</label><br>
		<select name="admin" required>
		    <option value="1" <c:if test="${userupdate.admin == 1}">selected</c:if>>Quản Trị</option>
		    <option value="0" <c:if test="${userupdate.admin == 0}">selected</c:if>>Người Dùng</option>
		</select><br/>
		  
		<hr>
		<input class="input-bordered bg-primary text-light" type="submit" value="Cập Nhật">
	</form>
</div>
</div>
</body>
</html>