
/*------------------------------------------------
 * Class: mySQLConnection
 * Programmer: Mr.Niyom Chamaree
 * Student No.: 6596004256
 * Date: 03/01/2026
 -------------------------------------------------*/

package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mySQLConnection {
	
    private static final String URL = "jdbc:mysql://localhost:3306/thesecond_dbs";
    private static final String USER = "root";
    private static final String PASSWORD = "P@55w0rd";

    public static Connection getConnection() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }

	public static void excuteNoneQuery(String sql, String[] params) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					int index = i + 1;
					preparedStatement.setString(index, params[i]);
				}
			}
			
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet excuteQuery(String sql, String[] params) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					int index = i + 1;
					preparedStatement.setString(index, params[i]);
				}
			}
			
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

