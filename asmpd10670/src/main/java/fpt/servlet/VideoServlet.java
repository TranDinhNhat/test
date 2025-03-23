package fpt.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import fpt.dao.FavoriteDao;
import fpt.dao.VideoDao;
import fpt.entity.Favorite;
import fpt.entity.User;
import fpt.entity.Video;

@MultipartConfig
@WebServlet({"/Video/admin","/Video/nguoidung" , "/Video/admin/create", "/Video/admin/delete","/Video/admin/update","/Video/admin/search", "/Video/admin/search-trangchu","/Video/admin/view","/Video/admin/like",
	"/Video/nguoidung/create","/Video/nguoidung/delete","/Video/nguoidung/update","/Video/nguoidung/search","/Video/nguoidung/search-trangchu","/Video/nguoidung/view",
	"/Video/home/search-trangchu" ,"/Video/home/view"
	})
public class VideoServlet extends HttpServlet {
	VideoDao dao = new VideoDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		if ("/Video/admin/create".equals(action)) {
			req.getRequestDispatcher("/views/admin/VideoCreate.jsp").forward(req, resp);
		}
		if("/Video/admin/update".equals(action)) {
			String id = req.getParameter("id");
			Video videoList = dao.findById(id);
			req.setAttribute("videoUpdate", videoList);
			req.getRequestDispatcher("/views/admin/VideoUpdate.jsp").forward(req, resp);
		}
		if("/Video/admin".equals(action)) {
		List<Video> videoList = dao.findAll();
		req.setAttribute("videoList", videoList);
		req.getRequestDispatcher("/views/admin/QuanLyVideo.jsp").forward(req, resp);
		}
		if ("/Video/nguoidung/create".equals(action)) {
			req.getRequestDispatcher("/views/nguoidung/VideoCreate.jsp").forward(req, resp);
		}
		if("/Video/nguoidung/update".equals(action)) {
			String id = req.getParameter("id");
			Video videoList = dao.findById(id);
			req.setAttribute("videoUpdate", videoList);
			req.getRequestDispatcher("/views/nguoidung/VideoUpdate.jsp").forward(req, resp);
		}
	 
		
		if ("/Video/admin/search".equals(action)) {
			String query = req.getParameter("query");
			List<Video> searchList = dao.findAll();
			req.setAttribute("searchList", searchList);
			req.setAttribute("query", query);
			req.getRequestDispatcher("/views/admin/layout-search-video.jsp").forward(req, resp);
		}
		if ("/Video/admin/search-trangchu".equals(action)) {
			req.getRequestDispatcher("/views/admin/layout-search-trangchu.jsp").forward(req, resp);
		}
		if ("/Video/nguoidung/search-trangchu".equals(action)) {
			req.getRequestDispatcher("/views/nguoidung/layout-search-trangchu.jsp").forward(req, resp);
		}
		if ("/Video/home/search-trangchu".equals(action)) {
			req.getRequestDispatcher("/views/layout-search-trangchu.jsp").forward(req, resp);
		}

		if ("/Video/home/view".equals(action)) {
	        String id = req.getParameter("id");
	        Video video = dao.findById(id);
	        if (video != null) {
	            // Tăng lượt xem
	            video.setViews(video.getViews() + 1);
	            dao.update(video); // Cập nhật video vào cơ sở dữ liệu
	            
	            // Chuyển tiếp đến trang xem video
	            req.setAttribute("video", video);
	            req.getRequestDispatcher("/views/trangchu-detall.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("errorMessage", "Video không tồn tại.");
	            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
	        }
	        return;
	    }
		if ("/Video/admin/view".equals(action)) {
	        String id = req.getParameter("id");
	        Video video = dao.findById(id);
	        if (video != null) {
	            // Tăng lượt xem
	            video.setViews(video.getViews() + 1);
	            dao.update(video); // Cập nhật video vào cơ sở dữ liệu
	            
	            // Chuyển tiếp đến trang xem video
	            req.setAttribute("video", video);
	            req.getRequestDispatcher("/views//admin/trangchu-detall.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("errorMessage", "Video không tồn tại.");
	            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
	        }
	        return;
	    }
		if ("/Video/nguoidung/view".equals(action)) {
	        String id = req.getParameter("id");
	        Video video = dao.findById(id);
	        if (video != null) {
	            // Tăng lượt xem
	            video.setViews(video.getViews() + 1);
	            dao.update(video); // Cập nhật video vào cơ sở dữ liệu
	            
	            // Chuyển tiếp đến trang xem video
	            req.setAttribute("video", video);
	            req.getRequestDispatcher("/views/nguoidung/trangchu-detall.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("errorMessage", "Video không tồn tại.");
	            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
	        }
	        return;
	    }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
		String action = req.getServletPath();
		Video video = new Video();
		if ("/Video/admin/create".equals(action)) {
			String id = req.getParameter("id");
			String active = req.getParameter("active");
			String description = req.getParameter("description");
			
			Part filePart = req.getPart("ava");
			String fileName = filePart.getSubmittedFileName();
			String dinhDang = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = id + dinhDang;
			String path = "C:\\eclipjava\\asmpd10670\\src\\main\\webapp\\images\\";
			filePart.write(path + newFileName);
			String poster =newFileName;
			
			String title = req.getParameter("title");
			int views = Integer.parseInt(req.getParameter("views"));
			
			try {
				video.setId(id);
				video.setActive("Đang Hoạt Động".equals(active));
				video.setDescription(description);
				video.setPoster(poster);
				video.setTitle(title);
				video.setViews(views);
				
				dao.insert(video);
				resp.sendRedirect("/asmpd10670/Video/admin");
			} catch (Exception e) {
				req.setAttribute("/errorMesage", "Đăng Video Không Thành Công!");
				req.getRequestDispatcher("/views/admin/VideoCreate.jsp").forward(req, resp);
			}
		}
		if ("/Video/admin/update".equals(action)) {
			String id = req.getParameter("id");
			String active = req.getParameter("active");
			String description = req.getParameter("description");
			Part filePart = req.getPart("ava");
			String fileName = filePart.getSubmittedFileName();
			String dinhDang = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = id + dinhDang;
			String path = "C:\\eclipjava\\asmpd10670\\src\\main\\webapp\\images\\";
			filePart.write(path + newFileName);
			String poster =newFileName;

			String title = req.getParameter("title");
		
			try {
				video.setId(id);
				video.setActive("Đang Hoạt Động".equals(active));
				video.setDescription(description);
				video.setPoster(poster);
				video.setTitle(title);

				dao.update(video);
				resp.sendRedirect("/asmpd10670/Video/admin");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Cập nhật không thành công!");
				req.getRequestDispatcher("/views/admin/VideoUpdate.jsp").forward(req, resp);
			}
		}else if ("/Video/admin/delete".equals(action)) {
			String id = req.getParameter("id");
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Video/admin");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công!");
				req.setAttribute("user", "/asmpd10670/Video/admin/delete");
			}
		}
		if ("/Video/nguoidung/create".equals(action)) {
			String id = req.getParameter("id");
			String active = req.getParameter("active");
			String description = req.getParameter("description");
			
			Part filePart = req.getPart("ava");
			String fileName = filePart.getSubmittedFileName();
			String dinhDang = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = id + dinhDang;
			String path = "C:\\eclipjava\\asmpd10670\\src\\main\\webapp\\images\\";
			filePart.write(path + newFileName);
			String poster =newFileName;
			
			String title = req.getParameter("title");
			int views = Integer.parseInt(req.getParameter("views"));
			
			try {
				video.setId(id);
				video.setActive("Đang Hoạt Động".equals(active));
				video.setDescription(description);
				video.setPoster(poster);
				video.setTitle(title);
				video.setViews(views);
				
				dao.insert(video);
				resp.sendRedirect("/asmpd10670/Video/nguoidung");
			} catch (Exception e) {
				req.setAttribute("/errorMesage", "Đăng Video Không Thành Công!");
				req.getRequestDispatcher("/views/nguoidung/VideoCreate.jsp").forward(req, resp);
			}
		}
		if ("/Video/nguoidung/update".equals(action)) {
			String id = req.getParameter("id");
			String active = req.getParameter("active");
			String description = req.getParameter("description");
			Part filePart = req.getPart("ava");
			String fileName = filePart.getSubmittedFileName();
			String dinhDang = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = id + dinhDang;
			String path = "C:\\eclipjava\\asmpd10670\\src\\main\\webapp\\images\\";
			filePart.write(path + newFileName);
			String poster =newFileName;

			String title = req.getParameter("title");
		
			try {
				video.setId(id);
				video.setActive("Đang Hoạt Động".equals(active));
				video.setDescription(description);
				video.setPoster(poster);
				video.setTitle(title);

				dao.update(video);
				resp.sendRedirect("/asmpd10670/Video/nguoidung");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Cập nhật không thành công!");
				req.getRequestDispatcher("/views/nguoidung/VideoUpdate.jsp").forward(req, resp);
			}
		}else if ("/Video/nguoidung/delete".equals(action)) {
			String id = req.getParameter("id");
			try {
				dao.delete(id);
				resp.sendRedirect("/asmpd10670/Video/nguoidung");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("errorMesage", "Xóa không thành công!");
				req.setAttribute("user", "/asmpd10670/Video/nguoidung/delete");
			}
		}
		 
		
	}
	
}
