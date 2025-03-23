<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="fpt.entity.User" %>
<%@ page import="fpt.dao.UserDao" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/Layouts/header-admin.jsp"></jsp:include>


            
            <div style="padding-top: 40px; padding-left: 350px;">
<div class="content">
                <table class="table table-bordered">
                	<thead>
                	<tr>
                		<th>Mã đăng nhập</th>
                		<th>Mật khẩu</th>
                		<th>Email</th>
                		<th>Họ và Tên</th>
                		<th>Vai trò </th>
                		<th>Sửa thông tin</th>
                		<th>Xóa người dùng </th>
                	</tr>
                	</thead>
                	<%
    String query = request.getParameter("query");
    if (query != null && !query.trim().isEmpty()) {
        UserDao dao = new UserDao();
        List<User> resultList = dao.searchByKeyWord(query);
        for (User user : resultList) {
%>
                	<tbody>
                		<c:forEach var = "item" items = "${user }" >
                			<tr>
                				<td><%= user.getId() %></td>
                				<td><%= user.getPassword() %></td>
                				<td><%= user.getEmail() %></td>
                				<td><%= user.getFullname() %></td>
								<td>
	                				<%= user.getAdmin() %>
                				</td>
                				<td>
				<a href="${pageContext.request.contextPath}/User/update?id=<%= user.getId() %>">
					    <button class="text-light bg-primary btn-action btn-edit"
					    style="border:12px soli; border-radius:10px">Chỉnh Sửa Thông Tin</button>
					</a>
			</td>
			<td> <form action="/asmpd10670/User/delete" method="post">
					<input class="form-control"	name="id" value="<%= user.getId() %>" type="hidden">
					<button class="text-light bg-primary btn-action btn-delete" onclick= "return confirm('Bạn có chắc chắn muốn xóa người dùng này');" 
					style="border:12px soli;border-radius:12px;">Xóa Người Dùng</button>	
					</form> 
				</td>
                			</tr>
                			
                		</c:forEach>
                	</tbody>
                	<%
        }
        if (resultList.isEmpty()) {
%>
            <p>Không tìm thấy người dùng nào khớp với từ khóa.</p>
            <br>
            <a href="/asmpd10670/User" class="form-bordered text-light bg-primary   p-2"
			style="border:12px soli; border-radius:10px;
			text-decoration: none;">Danh Sách Người Dùng</a>
<%
        }
    }
%>
                </table>
                
                </div>
                </div> <br>
                <hr>
                <a href="/asmpd10670/User" class="form-bordered text-light bg-primary   p-2"
			style="border:12px soli; border-radius:10px;
			text-decoration: none;">Danh Sách Người Dùng</a>


</body>
</html>