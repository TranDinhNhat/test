package fpt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.dao.ShareDao;
import fpt.entity.Share;
import fpt.entity.User;

@WebServlet({"/Share/admin","/Share/admin/delete",
	"/Share/nguoidung", "/Share/nguoidung/delete"})
public class ShareServlet extends HttpServlet {
	ShareDao dao = new ShareDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if ("/Share/admin".equals(action)) {
			List<Share> shareList = dao.findAll();
			req.setAttribute("shareList", shareList);
			req.getRequestDispatcher("/views/admin/Share.jsp").forward(req, resp);
		}
		if ("/Share/nguoidung".equals(action)) {
			HttpSession session = req.getSession();
			User userId = (User)session.getAttribute("users");
			List<Share> shareList = dao.findId(userId.getId().toString());
			req.setAttribute("shareList", shareList);
			req.getRequestDispatcher("/views/nguoidung/Share.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
		String action = req.getServletPath();
		if ("/Share/admin/delete".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Share/admin");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công!");
				req.setAttribute("user", "/asmpd10670/Share/admin");
			}
		}
		if ("/Share/nguoidung/delete".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Share/nguoidung");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công");
				req.getRequestDispatcher("/views/nguoidung/Share.jsp").forward(req, resp);
			}
		}
	}
}
