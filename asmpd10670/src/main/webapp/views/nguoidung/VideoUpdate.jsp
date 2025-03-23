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
}

<title>Cập nhật nội dung video</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-nguoidung.jsp"></jsp:include>
<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
<h2>Chỉnh sửa nội dung video</h2>
	<form class="form-bordered" action="${pageContext.request.contextPath}/Video/nguoidung/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${videoUpdate.id }">
		<label>Tiêu Đề</label> <br>
		<input type="text" name="title" value="${videoUpdate.title }">
		<br>
		<label>Ảnh Bìa</label><br>
		<input type="file" name="ava"   >
		<br>
		<label>Lượt Xem</label><br>
		<input class="form-control" type="number" value="${videoUpdate.views }" readonly>
		<label>Nội Dung</label><br>
		<input type="text" name="description" value="${videoUpdate.description }">
		<br>
		<label>Trạng Thái</label><br>
		<select name="active">
			<option value="Đang Hoạt Động" <c:if test="${videoUpdate.active  }">selected</c:if>>Đang Hoạt Động</option>
			<option value="Chưa Hoạt Động" <c:if test="${!videoUpdate.active  }">selected</c:if>>Chưa Hoạt Động</option>
			</select>
			<br>
			<hr>
			<input class="" value="Cập Nhật" type="submit">
	</form>
</div>
</div>
</body>
</html>