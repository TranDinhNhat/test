package fpt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String action = req.getServletPath();
		if (session != null) {
			session.invalidate();
			
		}
		if ("/logout".equals(action)) {
			req.getRequestDispatcher("/views/trangchu.jsp").forward(req, resp);
		}
		
	}
}
