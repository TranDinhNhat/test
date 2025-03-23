package fpt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.dao.UserDao;
import fpt.entity.User;

@WebServlet({"/ProFile/admin","/ProFile/admin/edit",
	"/ProFile/nguoidung","/ProFile/nguoidung/edit"})
public class ProFileServlet extends HttpServlet {
	UserDao dao = new UserDao();
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi/-strong/-heart:>:o:-((:-h s
		if ("/ProFile/admin/edit".equals(action)) {
			HttpSession session = req.getSession();
			User findId = (User)session.getAttribute("users");
			List<User> userProFile = dao.findId(findId.getId().toString());
			req.setAttribute("userEditProFile", userProFile);
			req.getRequestDispatcher("/views/admin/EditProFile.jsp").forward(req, resp);
 		}
		if ("/ProFile/admin".equals(action)) {
			HttpSession session = req.getSession();
			User findId = (User)session.getAttribute("users");
			List<User> userProFile = dao.findId(findId.getId().toString());
			req.setAttribute("userProFile", userProFile);
			req.getRequestDispatcher("/views/admin/ProFile.jsp").forward(req, resp);
		}
		if ("/ProFile/nguoidung".equals(action)) {
			HttpSession session = req.getSession();
			User findid = (User) session.getAttribute("users");
			List<User> userProFile = dao.findId(findid.getId().toString());
			req.setAttribute("userProFile", userProFile);
			req.getRequestDispatcher("/views/nguoidung/ProFile.jsp").forward(req, resp);
		}
		if ("/ProFile/nguoidung/edit".equals(action)) {
			HttpSession session = req.getSession();
			User findid = (User) session.getAttribute("users");
			List<User> userProFile = dao.findId(findid.getId().toString());
			req.setAttribute("userProFile", userProFile);
			req.getRequestDispatcher("/views/nguoidung/EditProFile.jsp").forward(req, resp);
		}
		 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		UserDao dao = new UserDao();
		User u = new User();
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi/-strong/-heart:>:o:-((:-h 
		if ("/ProFile/admin/edit".equals(action)) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			int admin = Integer.parseInt(req.getParameter("admin"));
			try {
				u.setId(id);
				u.setPassword(password);
				u.setEmail(email);
				u.setFullname(fullname);
				u.setAdmin(admin);
				
				dao.update(u);
				resp.sendRedirect("/asmpd10670/index/admin");
			} catch (Exception e) {
				req.setAttribute("errorMessage", "Lỗi");
				resp.sendRedirect("/asmpd10670/index/admin");
			}
		}
		if ("/ProFile/nguoidung/edit".equals(action)) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			int admin = Integer.parseInt(req.getParameter("admin"));
			try {
				u.setId(id);
				u.setPassword(password);
				u.setEmail(email);
				u.setFullname(fullname);
				u.setAdmin(admin);
				
				dao.update(u);
				resp.sendRedirect("/asmpd10670/index/nguoidung");
			} catch (Exception e) {
				req.setAttribute("errorMessage", "Lỗi");
				resp.sendRedirect("/asmpd10670/index/nguoidung");
			}
		}
	}
}
