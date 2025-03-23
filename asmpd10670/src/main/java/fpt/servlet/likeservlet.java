package fpt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fpt.dao.FavoriteDao;
import fpt.entity.Favorite;
import fpt.entity.User;

@WebServlet("/like")
public class likeservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 FavoriteDao dao = new FavoriteDao();
		 HttpSession session = req.getSession();
		 User user = (User)session.getAttribute("users");
		 List<Favorite> findid = dao.findId(user.getId().toString());
		 req.setAttribute("favorite", findid);
		 req.getRequestDispatcher("/views/like.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
