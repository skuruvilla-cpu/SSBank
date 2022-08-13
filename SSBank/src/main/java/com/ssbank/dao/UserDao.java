package com.ssbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ssbank.model.*;

public class UserDao {
	ConnectionDao connObj = new ConnectionDao();
	Connection con = connObj.createConnection();
	
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
			System.out.println(rs);
			while(rs.next()) {
				userObj = new User(
						rs.getInt("user_id"), rs.getString("first_name"),  rs.getString("last_name"), rs.getDate("dob"), rs.getString("gender"), rs.getString("email"),
						rs.getInt("phone_number"), rs.getString("street_address"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"),
						rs.getString("nationality"),rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userObj;
	}
	
	
}
