package fpt.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.dao.UserDao;
import fpt.entity.User;

@WebServlet("/dangki")
public class DangKiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/dangki.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new User();
		UserDao dao = new UserDao();
		req.setCharacterEncoding("UTF-8"); // Đặt mã hóa cho yêu cầu
	    resp.setContentType("text/html; charset=UTF-8"); // Đặt mã hóa cho phản hồi
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
			
			 if (dao.isEmailExists(email)) {
			        req.setAttribute("errorMessage", "Email đã tồn tại, vui lòng chọn email khác!");
			        req.getRequestDispatcher("/views/dangki.jsp").forward(req, resp);
			        return;
			    }
			 if (dao.isUserlExists(id)) {
			        req.setAttribute("errorMessage", "User đã tồn tại, vui lòng chọn tên user khác!");
			        req.getRequestDispatcher("/views/dangki.jsp").forward(req, resp);
			        return;
			    }
			dao.insert(u);
			req.setAttribute("err", "User created successfully!");
			sendmail(email);
			resp.sendRedirect("/asmpd10670/login");
		} catch (Exception e) {
			req.setAttribute("errorMesage", "Tên đăng nhập hoặc email không tồn tại!");
			req.getRequestDispatcher("/views/dangki.jsp").forward(req, resp);
		}
	}
	private void sendmail(String email) throws MessagingException{
    	// B1: Cấu hình thông số mail SMTP
    			Properties props = new Properties();
    			props.setProperty("mail.smtp.auth", "true");
    			props.setProperty("mail.smtp.port", "587");	
    			props.setProperty("mail.smtp.starttls.enable", "true");
    			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
    			props.setProperty("mail.smtp.host", "smtp.gmail.com");
    			// B2: Kết nối SMTP Server
    			Session session = Session.getInstance(props, new Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
    					String username = "nhattdpd10855@gmail.com"; // Tài khoản đăng nhập
    					String password = "xvulyzfrapaszuzo"; // Mật khẩu đăng nhập 
    					return new PasswordAuthentication(username, password);
    				}
    			});
//    			System.out.println(session);
    			// B3: Tạo mail
    			MimeMessage message = new MimeMessage(session);
    			try {
    				message.setFrom(new InternetAddress("nhattdpd10855@gmail.com")); // Tài khoản đăng nhập để gửi mail
    				message.setRecipients(Message.RecipientType.TO, email); // Tài khoản nhận mail
    				message.setSubject("Đăng kí tài khoản thành công", "utf-8");
    				message.setText("Dear Admin, Welcome to website!" + "" +email, "utf-8", "html");
    				message.setReplyTo(message.getFrom());
    				// B4: Gửi mail đi
    				Transport.send(message);
    			} catch (MessagingException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	
    }
}
