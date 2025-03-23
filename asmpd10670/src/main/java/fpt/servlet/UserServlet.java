package fpt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.dao.UserDao;
import fpt.entity.User;

@WebServlet({"/User" , "/User/create" , "/User/update", "/User/delete" , "/User/search", "/User/read"})
public class UserServlet extends HttpServlet {
	UserDao dao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String action  = req.getServletPath();
	req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
    if ("/User/search".equals(action)) {
    	String query = req.getParameter("query");	
		List<User> searchList = dao.searchByKeyWord(query);
		req.setAttribute("searchList", searchList);
		req.setAttribute("query", query);
		req.getRequestDispatcher("/views/admin/layout-search-nguoidung.jsp").forward(req, resp);
	}
	if ("/User/create".equals(action)){
		req.getRequestDispatcher("/views/admin/UserCreate.jsp").forward(req, resp);
	}else if("/User/update".equals(action)) {
		String id = req.getParameter("id");
		User userList = dao.findById(id);
		req.setAttribute("userupdate", userList);
		req.getRequestDispatcher("/views/admin/UserUpdate.jsp").forward(req, resp);
	}else {
		List<User> userList = dao.findAll();
		 req.setAttribute("userList",userList);
		 req.getRequestDispatcher("/views/admin/QuanLyNguoiDung.jsp").forward(req, resp);
	}
	 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new User();
		UserDao dao = new UserDao();
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
		String action = req.getServletPath();
		if(action.equals("/User/create")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			Integer admin = Integer.parseInt(req.getParameter("admin"));
			
			try {
				u.setId(id);
				u.setPassword(password);
				u.setEmail(email);
				u.setFullname(fullname);
				u.setAdmin(admin);
				
				dao.insert(u);
				resp.sendRedirect("/asmpd10670/User");
			} catch (Exception e) {
				req.setAttribute("errorMesage", "Mã người dùng hoặc email đã tồn tại! Vui lòng nhập lại");
				req.getRequestDispatcher("/views/Admin/UserCreate.jsp").forward(req, resp);
				 	
			}
		}else if(action.equals("/User/delete")) {
			String id = req.getParameter("id");
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/User");
			} catch (Exception e) {
				req.setAttribute("erroMessage", "Xóa không thành công ! Vui lòng thử lại.");
				req.setAttribute("user"	,"/new/User");
			}
			
		}
		
		if (action.equals("/User/update")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			Integer admin = Integer.parseInt(req.getParameter("admin"));
			
			try {
				u.setId(id);
				u.setPassword(password);
				u.setEmail(email);
				u.setFullname(fullname);
				u.setAdmin(admin);
				
				dao.update(u);
				
				resp.sendRedirect("/asmpd10670/User");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Cập nhật không thành công");
				req.getRequestDispatcher("/views/admin/UserUpdate.jsp").forward(req, resp);
				
			}
		}
	 
		 
	}
}