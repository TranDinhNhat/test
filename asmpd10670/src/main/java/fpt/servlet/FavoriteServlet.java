package fpt.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import fpt.dao.FavoriteDao;
import fpt.dao.VideoDao;
import fpt.entity.Favorite;
import fpt.entity.User;
import fpt.entity.Video;

@WebServlet({"/Favorite/admin", "/Favorite/admin/search", "/Favorite/admin/delete","/Favorite/admin/click-like",
	"/Favorite/nguoidung","/Favorite/nguoidung/delete","/Favorite/nguoidung/click-like"})
public class FavoriteServlet extends HttpServlet {
	FavoriteDao dao = new FavoriteDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if ("/Favorite/admin".equals(action)) {
			List<Favorite> favoriteList = dao.findAll();
			req.setAttribute("favoriteList", favoriteList);
			req.getRequestDispatcher("/views/admin/Favorite.jsp").forward(req, resp);
		}
		if ("/Favorite/nguoidung".equals(action)) {
			HttpSession session = req.getSession();
			User userId = (User) session.getAttribute("users");
			List<Favorite> findId = dao.findId(userId.getId().toString());
			req.setAttribute("findUser", findId);
			req.getRequestDispatcher("/views/nguoidung/Favorite.jsp").forward(req, resp);
		}
 
		if ("/Favorite/admin/search".equals(action)) {
			String query = req.getParameter("query");
			List<Favorite> searchList = dao.searchByKeyWord(query);
			req.setAttribute("searchList", searchList);
			req.setAttribute("query", query);
			req.getRequestDispatcher("/views/admin/layout-search-videolike.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
		String action = req.getServletPath();
		Favorite f = new Favorite();
		if ("/Favorite/admin/delete".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Favorite/admin");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công!");
				req.setAttribute("user", "/asmpd10670/Favorite/admin");
			}
		}
		if ("/Favorite/nguoidung/delete".equals(action)) {
			String id = req.getParameter("id");
			try {		
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Favorite/nguoidung");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công!");
				req.setAttribute("user", "/asmpd10670/Favorite/nguoidung");
			}
		}
 
	}
}
