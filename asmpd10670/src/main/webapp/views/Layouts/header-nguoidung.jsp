<%@page import="fpt.entity.User"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>	
</head>
<style>
 
</style>
<body>
 <div class="header">
 <header class="row bg-dark fixed-top" style="height: 55px;">
  <div class="col-sm-5"></div>
 <div class="col-sm-2">
 <img alt="" src="https://designshack.net/wp-content/uploads/Logo-Animations-for-After-Effects-1.jpg" width="90px;">
 </div>
 <div class="col-sm-5"></div>
 
 <div class="col-sm-8" style="border:none; text-align: center;">
				    </div>
 </header>
</div>
<div style="padding-top: 45px;">
 <div class="flex-shrink-0 p-3 bg-white " style="width: 280px; position: fixed; ">
    <ul class="list-unstyled ps-0">
      <li class="mb-1">
        <button class="btn btn-toggle align-items-center rounded collapsed">
          <b>Home</b>
        </button>
         
        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
            <li><a class="nav-link text-dark active" aria-current="page" href="/asmpd10670/index/nguoidung">
                                Trang chủ
                          </a></li>
            <li><a class="nav-link text-dark active" aria-current="page" href="/asmpd10670/Favorite/nguoidung">
            	 VideoLike</a></li>
            <li><a class="nav-link text-dark active" aria-current="page" href="/asmpd10670/Share/nguoidung">
            	 </i>Vieo tôi đã share Share</a></li>
          </ul>
      </li>
 
      <li class="border-top my-3"></li>
      <li class="mb-1">
        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
          <b>Thông Tin Cá Nhân</b>
        </button>
        
       <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
            
            <li><a href="/asmpd10670/ProFile/nguoidung" class="nav-link text-dark">Profile</a></li>
            
            <c:if test="${sessionScope.users == null }">
                              <li><a class="dropdown-item" href="/asmpd10670/login">Đăng nhập</a></li>
                          </c:if>
                          <c:if test="${sessionScope.users != null }"> 
                          <li>
                          <form action="/asmpd10670/logout" method="post">
                          	 
                          	 <input type="submit" value="Đăng xuất" class="nav-link btn text-dark">
                          </form>
                          </li>
                              </c:if>
          </ul>
      </li>
    </ul>
    <div class=" " style="border:none;display:  flex;">
                      <form action="/asmpd10670/Video/nguoidung/search-trangchu" method="get" class="mx-3">
				        <input type="text" name="query" placeholder="Nhập từ khóa tìm kiếm..." 
				        style="border:none; border-radius:10px;width: 50%; height: 50px;
				        background-color: width; color: black;">
				        <button type="submit" style="border:none; border-radius: 12px; height: 50px; background-color: width; color: black;">Tìm Kiếm</button>
				    </form>
				    </div>
  </div>
 </div>
</body>
</html>