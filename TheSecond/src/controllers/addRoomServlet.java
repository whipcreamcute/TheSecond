package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Room;
import models.User;
import services.RoomService;
import services.UserService;

/**
 * Servlet implementation class addRoomServlet
 */
@WebServlet("/addRoomServlet")
public class addRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomNo, roomName;
		int status;

		roomNo = request.getParameter("roomNo");
		roomName = request.getParameter("roomName");
		status = Integer.parseInt(request.getParameter("status"));
		
		Room room = new Room(roomNo, roomName, status);

		RoomService service = (RoomService) getServletContext().getAttribute("roomService");
		
		boolean success = service.addRoom(room);
		
		if (success) {
			 response.sendRedirect("rooms.jsp");
		}else {
			// error
			response.sendRedirect("rooms.jsp");
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
