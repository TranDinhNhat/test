<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Insert title here</title>
</head>
<body>
 <header>
  <div
    class="  text-center bg-image"
    style="
      background-image: url('https://i.imgur.com/CHo8JDy.png');
      height: 600px;
    "
  >
    
  </div>
  <!-- Background image -->
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

              <a class="navbar-brand" href="#">
                  <img src="https://i.imgur.com/Cy7eHYu.png" alt="Logo" style="width: 50px;">
              </a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav">
                      <li class="nav-item">
                          <a class="nav-link active" aria-current="page" href="/Lab3/index">
                              <i class="fas fa-home"></i> Trang chủ
                          </a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/new/User">
                              <i class="fas fa-book"></i> Users
                          </a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/new/Video/admin">
                              <i class="fas fa-video"></i> Video
                          </a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/new/Favorite/admin">
                              <i class="fas fa-video"></i> VideoLike
                          </a>
                      </li>
                      
                      <li class="nav-item">
                          <a class="nav-link" href="#">
                              <i class="fas fa-user"></i> Reports
                          </a>
                      </li>
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
                              <i class="fas fa-user"></i> Tài khoản
                          </a>
                          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
                              <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
                              <li><a class="dropdown-item" href="#">Đăng ký thành viên</a></li>
                          </ul>
                      </li>
                  </ul>
                  
              </div>
              <ul  class="navbar-nav">
              
                <li class="nav-item">
                    <a href="" class="dropdown-item">Tiếng Anh</a>
                </li>
                <li class="nav-item">
                  <a href="" class="dropdown-item">Tiếng Việt</a>
              </li>
              </ul> 
               
	
      </nav>
      
</body>
</html>