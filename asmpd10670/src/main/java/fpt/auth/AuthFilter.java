//package fpt.auth;
//
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import fpt.entity.User;
////@WebFilter({"/admin/*","/account/change-password"})
//@WebFilter({"/User/*","/ProFile/*","/Share/*","/Favorite/*","/Video/admin/*", "/Video/nguoidung/*"})
//public class AuthFilter implements Filter{
//	public static final String SECURITY_URI = "secureUri";
//	public static final String USER_URI = "userUri";
//	public static final String PROFILE_URI = "profileUri";
//	public static final String SHARE_URI = "shareUri";
//	public static final String FAVORITE_URI = "favoriteUri";
//	public static final String VIDEOADMIN_URI = "videoadminUri";
//	public static final String VIDEONGUOIDUNG_URI = "videonguoidungUri";
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {	
//		// TODO Auto-generated method stub
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//		User user = (User) session.getAttribute("users");
//		String uri = req.getRequestURI();
//		if (user == null) {
//			session.setAttribute(AuthFilter.USER_URI, uri);
//			session.setAttribute(AuthFilter.PROFILE_URI, uri);
//			session.setAttribute(AuthFilter.SHARE_URI, uri);
//			session.setAttribute(AuthFilter.FAVORITE_URI, uri);
//			session.setAttribute(AuthFilter.VIDEOADMIN_URI, uri);
//			session.setAttribute(AuthFilter.VIDEONGUOIDUNG_URI, uri);
//			
//			resp.sendRedirect(req.getContextPath()+"/views/login.jsp");
//		}else {
//			chain.doFilter(request, response);
//		}
//			
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//}
