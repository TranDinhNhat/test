<%@page import="java.util.List"%>
<%@page import="fpt.entity.Video"%>
<%@page import="fpt.dao.VideoDao"%>
<%@page import="fpt.entity.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
      <style>

        .sidebar {
            width: 250px;
            height:100%;
            background-color: black;
            color: white;
            transition: width 0.3s, transform 0.3s;
            overflow: hidden;
        }
        .sidebar.hidden {
            width: 0;
            transform: translateX(-100%);
        }
        .toggle-btn {
            background-color: #444;
            border: none;
            color: white;
            padding: 10px;
            cursor: pointer;
            width: 100%;
        }
        .menu {
            list-style-type: none;
            padding: 0;
        }
        .menu li {
            padding: 15px;
        }
        .menu li:hover {
            background-color: #575757;
        }
        .content {
            flex-grow: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
<header  style="margin-bottom: 40px;">
 <div class=" row d-flex bg-dark fixed-top">
 <div class="col-sm-2">
	 <button class="toggle-btn" style="width: 50px;" onclick="toggleSidebar()">☰</button>
	 </div>
	 <div class="col-sm-8" style="text-align: center;">
	 <div class=" search ">
                      <form action="/Asm/Video/nguoidung/search-trangchu" method="get" class="m-2"  >
				        <input type="text" name="query" placeholder="Nhập từ khóa tìm kiếm..." 
				        style="border-radius:12px ; border: none; width: 50%;height: 80%; ">
				        <input type="submit" class="form-bordered" value="Tìm Kiếm"
				        style="border:none; border-radius:10px;">
				    </form>
				    </div>
				    </div>
				    <div class="col-sm-2">
				    	<%
              User user = (User) session.getAttribute("users");
              if(user != null){
            	  %>
            	  <h4 class=" bg-light.bg-gradient " 
            	  style="font-family: Tahoma, Verdana, sans-serif;"><%= user.getFullname() %> </h4> 
             <% }%>
				    </div>
				    </div>
				    </header>
 <div class="d-flex " style="">
 <nav class="" style="position: fixed;">
 <div>
    <div class="sidebar" id="sidebar">
       
        <ul class="menu">
            <li class="nav-item">
                          <a class="nav-link active" aria-current="page" href="/Asm/index/admin">
                              <i class="fas fa-home"></i> Trang chủ
                          </a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/Asm/User">
                              <i class="fas fa-book"></i> Users
                          </a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/Asm/Video/admin">
                              <i class="fas fa-video"></i> Video
                          </a>
                      </li>
                      
                 
             
                    
                              <li class="nav-item"><a class="nav-link active" href="/Asm/Favorite/admin">VideoLike</a></li>
                              <li class="nav-item"><a class="nav-link active"  href="/Asm/Share/admin">Quản Lý Share</a></li>
 
                        
                     
                      
        
              
                          
                          <c:if test="${sessionScope.users == null }">
                              <li class="nav-item"><a class="nav-link active"  href="/Asm/login">Đăng nhập</a></li>
                          </c:if>
                          <c:if test="${sessionScope.users != null }"> 
                          <li>
                          <form action="/Asm/logout" method="post">
                          	 
                          	 <input type="submit" value="Đăng xuất" class="nav-link btn ">
                          </form>
                          </li>
                              </c:if>
                              <li class="nav-item"><a class="nav-link active"  href="/Asm/Pass">Quên mật khẩu</a></li>
                          
 
        </ul>
        <div class="footer" style=" 
            padding: 15px;
            font-size: 12px;
            color: #999;
            text-align: center;
         ">
        Điều khoản dịch vụ · Bảo mật · Chính sách nội dung
    </div>
    </div>
    
    </div>
    </nav>
    <div class="container">
        <div class="row">
	
	<%VideoDao dao = new VideoDao();
		List<Video> videoList = dao.findAll();
		for(Video video : videoList){
		%>

		<div class="col-md-3 p-2">
		
		
			<div class="video-car">
				<div class="poster item-center text-center"> <img alt="" src="/Asm/images/<%=video.getPoster()%>" style="width: 300px; height: 200px;">  </div>
				<h5><%=video.getTitle() %></h5>
				<div class="d-flex">
				
				<form class="p-2" action="/Asm/like/admin" method="post">
				<input type="submit" name = "videoid" class="form-control" value="Thích">
				
				</form>
				
				<form class="p-2" action="/Asm/Share/admin">
				<input class="form-control" type="submit" value="Chia Sẻ">
				</form>
				
				</div>
			</div>
			
		</div>
		<%} %>
		</div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function toggleSidebar() {
            const sidebar = document.getElementById('sidebar');
            sidebar.classList.toggle('hidden');
        }
    </script>
</div>
</body>
</html>