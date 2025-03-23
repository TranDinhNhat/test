<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="fpt.entity.Favorite" %>
<%@ page import="fpt.dao.FavoriteDao" %>
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

<title>Video Yêu Thích</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>

<div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
                <table class="table table-bordered">
                	<thead>
                	<tr>
                		<th>Mã Video Thích</th>
                		<th>Tên Người Dùng </th>
                		<th>Tiêu Đề </th>
                		<th>Thời Gian </th>
                		<th>Xóa video khỏi danh sách thích  </th>
                	</tr>
                	</thead>
					   <%
					    String query = request.getParameter("query");
					    if (query != null && !query.trim().isEmpty()) {
					        FavoriteDao dao = new FavoriteDao();
					        List<Favorite> resultList = dao.searchByKeyWord(query);
					        for (Favorite favorite : resultList) {
					%>             	
                	<tbody>
                		
                			<tr>
                				<td><%= favorite.getId() %></td>
                				<td><%= favorite.getUser().getFullname() %></td>
                				<td><%= favorite.getVideo().getTitle() %></td>
                				<td><%= favorite.getLikedate() %></td>
								<td>
	                				 <form action="/asmpd10670/Favorite/admin/delete" method="post">
						<input class="form-control" name="id" value="<%= favorite.getId() %>" type="hidden">
						<button class="text-light bg-primary btn-action btn-delete" onclick="return confirm('Bạn có chắc chắn muốn xóa video này?')"
						style="border:12px soli; border-radius:10px;">Xóa người dùng đã like video</button>
					</form>
                				</td>
                				
                			</tr>
                			
                		
                	</tbody>
                	 <%
        }
        if (resultList.isEmpty()) {
%>
            <p>Không tìm thấy người dùng nào khớp với từ khóa.</p>
            <br>
            <a href="/asmpd10670/Favorite/admin" class="form-bordered text-light bg-primary   p-2"
			style="border:12px soli; border-radius:10px;
			text-decoration: none;">Quay lại</a>
<%
        }
    }
%>
                </table><br>
                <a href="/asmpd10670/Favorite/admin" class="form-bordered text-light bg-primary   p-2"
			style="border:12px soli; border-radius:10px;
			text-decoration: none;">Quay lại</a>
                </div>
               </div>
</body>
</html>