package fpt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.PostgreSQL10Dialect;

import fpt.dao.VideoDao;
import fpt.entity.Video;
@WebServlet({"/index","/index/admin", "/index/nguoidung"})
public class TrangChuServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String action = req.getServletPath();
	if ("/index".equals(action)) {
		req.getRequestDispatcher("/views/trangchu.jsp").forward(req, resp);
	}
	
	if ("/index/admin".equals(action)) {
		req.getRequestDispatcher("/views/admin/TrangChu.jsp").forward(req, resp);
	}		
	if("/index/nguoidung".equals(action)) {
		req.getRequestDispatcher("/views/nguoidung/TrangChu.jsp").forward(req, resp);
	}
}
}
