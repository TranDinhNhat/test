<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="fpt.entity.Video"%>
    <%@ page import="java.sql.ResultSet" %>
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
<title>Trang giải trí-Video</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>

<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
<h2 style="font-family: roboto">Danh Sách Video Đã Đăng</h2>
<form action="/asmpd10670/Video/admin/search" method="get" class="form-bordered p-2">
        <input type="text" name="query" placeholder="Nhập từ khóa tìm kiếm..." required 
        style="border:12px soli; border-radius:10px;">
        <input type="submit" value="Tìm Kiếm"class="form-bordered text-light bg-primary"
        style="border:12px soli; border-radius:10px;">
    </form>
<a class=" nav-link text-light bg-primary" href="/asmpd10670/Video/admin/create"
style="width: 160px; border:12px soli; border-radius:10px; margin-bottom: 10px">Thêm Video Mới</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>Mã Video</th>
			<th>Tiêu đề</th>
			<th>Ảnh Bìa</th>
			<th>Lượt Xem</th>
			<th>Nội Dung</th>
			<th>Trạng Thái</th>
			<th>Sửa Thông Tin</th>
			<th>Xóa Video</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${videoList }">
			<tr>
				<td>${item.id}</td>
				<td>${item.title }</td>
				<td> <img alt="" src="/asmpd10670/images/${item.poster }" style="width: 100px;"> </td>
				
				<td>${item.views }</td>
				<td>${item.description }</td>
				<td>${item.isActive() ? 'Đang Hoạt Động' : 'Chưa Hoạt Dộng'}</td>
				<td>
					<a href="${pageContext.request.contextPath}/Video/admin/update?id=${item.id}">
					<button class="btn-ation btn-edit text-light bg-primary"
					style="border:12px soli; border-radius:10px;">Chỉnh sửa video </button>
					</a>
				</td>
				<td>
					<form action="/asmpd10670/Video/admin/delete" method="post">
						<input class="form-control" name="id" value="${item.id }" type="hidden">
						<button class="text-light bg-primary btn-action btn-delete" onclick="return confirm('Bạn chắc chắn muốn xáo video này?')">Xóa video</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</body>
</html>