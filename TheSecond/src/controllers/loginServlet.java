package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email, password;

		email = request.getParameter("email");
		password = request.getParameter("password");

		UserService service = (UserService) getServletContext().getAttribute("userService");
		
		User user = service.getUserLogin(email, password);
		
		if (user != null) {
			
			// ดึง Session ปัจจุบัน หรือสร้างใหม่ถ้ายังไม่มี
			HttpSession session = request.getSession(); 
			
			session.setAttribute("userID", user.getId());
			session.setAttribute("userEmail", user.getEmail());
			session.setAttribute("userFullName", user.getFullName());
			session.setAttribute("userRole", user.getRole());
			
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
