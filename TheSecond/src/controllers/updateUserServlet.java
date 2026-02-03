package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import services.UserService;

/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName, email, phone, password, role;
		int id, status;

		id = Integer.parseInt(request.getParameter("userId"));
		fullName = request.getParameter("fullName");
		email = request.getParameter("email");
		password = request.getParameter("password");
		phone = request.getParameter("phone");
		role = request.getParameter("role");
		status = Integer.parseInt(request.getParameter("status"));
		
		
		User userRegister = new User(id, fullName, email, phone, password, role, status);

		UserService service = (UserService) getServletContext().getAttribute("userService");
		
		boolean success = service.updateUser(userRegister, id);
		
		if (success) {
			 response.sendRedirect("users.jsp");
		}else {
			// with error message
			response.sendRedirect("users.jsp");
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
