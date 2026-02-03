package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserService {

	private ArrayList<User> users;
	private Connection conn;

	
	public UserService() {
		this.conn = mySQLConnection.getConnection();
		users = new ArrayList<User>();
	}
	
	public boolean register(User user) {
		String sql = "INSERT INTO users (Email, FullName, Password, Phone, Role, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFullName());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, "");
            stmt.setString(5, "user");
            stmt.setInt(6, 1);
            stmt.executeUpdate();
            
            users.add(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (Email, FullName, Password, Phone, Role, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFullName());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getRole());
            stmt.setInt(6, user.getStatus());
            stmt.executeUpdate();
            
            users.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public boolean updateUser(User user, int userId) {
		String sql = "UPDATE users SET Email=?, FullName=?, Password=?, Phone=?, Role=?, Status=? WHERE UserId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFullName());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getRole());
            stmt.setInt(6, user.getStatus());
            stmt.setInt(7, user.getId());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public ArrayList<User> getUsers() {
		List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new User(rs.getInt("UserId"), rs.getString("FullName"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Password"), rs.getString("Role"), rs.getInt("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<User>) list;
	}
	
	public User getUser(int userId) {
		String sql = "SELECT * FROM users WHERE UserId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("UserId"), rs.getString("FullName"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Password"), rs.getString("Role"), rs.getInt("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public User getUserLogin(String email, String password) {
		String sql = "SELECT * FROM users WHERE Email=? AND Password=? AND Status=1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("UserId"), rs.getString("FullName"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Password"), rs.getString("Role"), rs.getInt("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	public void setUsers(Object users) {
		if(users!=null) {
			this.users = (ArrayList<User>)users;
		}
	}

	public User login(String email, String password) {
		if(users!=null) {
			for(User user: this.users) {
				if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
					return user;
				}
			}
		}
		return null;
	}

}
