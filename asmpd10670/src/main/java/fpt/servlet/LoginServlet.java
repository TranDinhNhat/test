package fpt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.dao.UserDao;
import fpt.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	UserDao dao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		//Lấy thông tin người dùng
		User users = dao.findById(id);
		if (users != null  && users.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("users", users);
			req.setAttribute("errorMessage", "Ban da dang nhap thanh cong");
			if (users.getAdmin() == 1) {
				resp.sendRedirect("views/admin/TrangChu.jsp");
			}else if(users.getAdmin() ==0){
				resp.sendRedirect("views/nguoidung/TrangChu.jsp");
			}
		}else {
			
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);	
		}
	}
}
