package controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import services.BookingService;
import services.RoomService;
import services.UserService;
/**
 * Application Lifecycle Listener implementation class serviceListener
 *
 */
@WebListener
public class serviceListener implements ServletContextListener {

	private UserService userService;
	private RoomService roomService;
	private BookingService bookingService;
    /**
     * Default constructor. 
     */
    public serviceListener() {
    	userService = new UserService();
    	roomService = new RoomService();
    	bookingService = new BookingService();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	sce.getServletContext().setAttribute("userService", userService);
    	sce.getServletContext().setAttribute("roomService", roomService);
    	sce.getServletContext().setAttribute("bookingService", bookingService);
    }
	
}
