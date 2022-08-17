package com.ssbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ssbank.model.*;

public class UserDao {
	static ConnectionDao connObj = new ConnectionDao();
	static Connection con = connObj.createConnection();
	
	public User getUserbyParam(Integer userid, String email){
		
		String query = "select * from users where ";
		if(userid !=null) {
			query += "user_id="+userid;
		}else if(email !=null){
			query += "email='"+email+"'";
		}
		User userObj = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				userObj = new User(
						rs.getInt("user_id"), rs.getString("first_name"),  rs.getString("last_name"), rs.getString("gender"), rs.getString("email"),
						rs.getString("phone_number"), rs.getString("street_address"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"),
						rs.getString("nationality"),rs.getString("password"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userObj;
	}
	
	public static Integer getUserCount(){
		Integer userCount=0;
		String query = "select MAX(user_id) as usercount from users ";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				userCount = rs.getInt("usercount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCount;
	}
	
	public int createUser(User newUser) {
		
		String sql = "insert into users (user_id, first_name, last_name, gender, email, phone_number, street_address, city, state, postal_code, nationality, password) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		int status = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, User.generateUserID());
			pstmt.setString(2, newUser.getFist_name());
			pstmt.setString(3, newUser.getLast_name());
			pstmt.setString(4, newUser.getGender());
			pstmt.setString(5, newUser.getEmail());
			pstmt.setString (6, newUser.getPhone_number());
			pstmt.setString(7, newUser.getStreet_address());
			pstmt.setString(8, newUser.getCity());
			pstmt.setString(9, newUser.getState());
			pstmt.setString(10, newUser.getPostal_code());
			pstmt.setString(11, newUser.getNationality());
			pstmt.setString(12, newUser.getPassword());

			
			status = pstmt.executeUpdate();

			if (status > 0) {

				return status;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
