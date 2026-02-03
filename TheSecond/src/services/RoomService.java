package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Room;

public class RoomService {

	private ArrayList<Room> rooms;
	private Connection conn;

	
	public RoomService() {
		this.conn = mySQLConnection.getConnection();
		rooms = new ArrayList<Room>();
	}
	
	
	public boolean addRoom(Room room) {
		String sql = "INSERT INTO rooms (RoomNo, RoomName, Status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getRoomNo());
            stmt.setString(2, room.getRoomName());
            stmt.setInt(3, room.getStatus());
            stmt.executeUpdate();
            
            rooms.add(room);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public boolean updateRoom(Room room, int roomId) {
		String sql = "UPDATE rooms SET RoomNo=?, RoomName=?, Status=? WHERE RoomId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getRoomNo());
            stmt.setString(2, room.getRoomName());
            stmt.setInt(3, room.getStatus());
            stmt.setInt(4, room.getId());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public ArrayList<Room> getRooms() {
		List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Room(rs.getInt("RoomId"), rs.getString("RoomNo"), rs.getString("RoomName"), rs.getInt("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Room>) list;
	}
	
	public ArrayList<Room> getActiveRooms() {
		List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE Status=1";
        
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Room(rs.getInt("RoomId"), rs.getString("RoomNo"), rs.getString("RoomName"), rs.getInt("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Room>) list;
	}
	
	public Room getRoom(int roomId) {
		String sql = "SELECT * FROM rooms WHERE RoomId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Room(rs.getInt("RoomId"), rs.getString("RoomNo"), rs.getString("RoomName"), rs.getInt("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
}
