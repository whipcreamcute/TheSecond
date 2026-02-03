package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Booking;

public class BookingService {
	private ArrayList<Booking> bookings;
	private Connection conn;

	
	public BookingService() {
		this.conn = mySQLConnection.getConnection();
		bookings = new ArrayList<Booking>();
	}
	
	
	public boolean addBooking(Booking book) {
		String sql = "INSERT INTO bookings (RoomId, UserId, BookingDateTime, Remark, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, book.getRoomId());
        	stmt.setInt(2, book.getUserId());
            stmt.setObject(3, book.getBookingDateTime());
            stmt.setString(4, book.getRemark());
            stmt.setInt(5, book.getStatus());
            stmt.executeUpdate();
            
            bookings.add(book);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return false;
    }

	public boolean updateBooking(Booking book, int roomId) {
		String sql = "UPDATE bookings SET RoomId=?, RoomName=?, BookingDateTime=?, Status=? WHERE RoomId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, book.getRoomId());
        	stmt.setInt(2, book.getUserId());
            stmt.setObject(3, book.getBookingDateTime());
            stmt.setString(4, book.getRemark());
            stmt.setInt(5, book.getStatus());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public ArrayList<Booking> getBookings() {
		List<Booking> list = new ArrayList<>();
        String sql = "SELECT b.BookingId, b.RoomId, b.UserId, b.BookingDateTime, b.Remark, u.FullName as UserName, u.Phone, r.RoomNo, r.RoomName, b.Status "
        		+ "FROM bookings b "
        		+ "JOIN users u on b.UserId = u.UserId "
        		+ "JOIN rooms r on b.RoomId = r.RoomId ";
        
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	//Booking(int id, int roomId, String roomNo, String roomName, int userId, String userName, String userPhone,
    			//LocalDateTime bookingDateTime, String remark, int status)
            	
                list.add(new Booking(rs.getInt("BookingId"), rs.getInt("RoomId"), rs.getString("RoomNo"),
                		rs.getString("RoomName"), rs.getInt("UserId"), rs.getString("UserName"), rs.getString("Phone"),
                		rs.getObject("BookingDateTime", LocalDateTime.class), rs.getString("Remark"), rs.getInt("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Booking>) list;
	}
	
	public ArrayList<Booking> getActiveBookings() {
		List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE Status=1";
        
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                //list.add(new Room(rs.getInt("RoomId"), rs.getString("RoomNo"), rs.getString("RoomName"), rs.getInt("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Booking>) list;
	}
	
	public Booking getBooking(int bookId) {
		String sql = "SELECT * FROM bookings WHERE BookingId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	//Booking(int id, int roomId, int userId, LocalDateTime bookingDateTime, String remark, int status)
                return new Booking(rs.getInt("BookingId"), rs.getInt("RoomId"), rs.getInt("UserId"), rs.getObject("BookingDateTime", LocalDateTime.class),rs.getString("Remark"), rs.getInt("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
}
