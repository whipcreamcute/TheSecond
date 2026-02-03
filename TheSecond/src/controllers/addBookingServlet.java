package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Booking;
import models.Room;
import services.BookingService;
import services.RoomService;

/**
 * Servlet implementation class addBookingServlet
 */
@WebServlet("/addBookingServlet")
public class addBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingDate, bookingTime, remark;
		int status, userId, roomId;
		
		HttpSession session = request.getSession(); 
		
		userId = Integer.parseInt(request.getParameter("userId"));
		roomId =  Integer.parseInt(request.getParameter("roomId"));
		bookingDate = request.getParameter("bookingDate");
		bookingTime = request.getParameter("bookingTime");
		remark = request.getParameter("remark");
		
		
		
		String dateString = bookingDate + " " + bookingTime;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime bookingDateTime = LocalDateTime.parse(dateString, formatter);
		
		status = 1;
		
		Booking booking = new Booking(roomId, userId, bookingDateTime, remark, status); 

		BookingService service = (BookingService) getServletContext().getAttribute("bookingService");
		
		boolean success = service.addBooking(booking);
		
		if (success) {
			 response.sendRedirect("bookings.jsp");
		}else {
			// error
			response.sendRedirect("create_booking.jsp");
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
