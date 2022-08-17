package com.ssbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ssbank.model.Account;
import com.ssbank.model.User;

public class AccountsDao {
	static ConnectionDao connObj = new ConnectionDao();
	static Connection con = connObj.createConnection();
	
	public List<Account> getAccountbyParam(Integer userId, String accountNo){
		
		List <Account> accountObjList = new ArrayList <Account>();
		Account accountObj = null;
		String query = "select * from accounts where ";
		if(userId !=null) {
			query += "user_id="+userId;
		}else if(accountNo !=null){
			query += "account_number='"+accountNo+"'";
		}
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				accountObj = new Account(
						rs.getString("account_number"),
						rs.getInt("user_id"),
						rs.getDouble("account_balance"),
						rs.getString("account_type"),
						rs.getString("account_status")
				);
				accountObjList.add(accountObj);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountObjList;
	}
	
	public int createAccounts(String accountype, Integer user_id) {
		String sql = "insert into accounts (account_number, user_id, account_balance, account_type, account_status) values(?,?,?,?,?)";
		
		int status = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//generating account number
			UUID uuid = UUID.randomUUID();
	        String accNumber = "ss"+uuid.toString().replace("-", "");
			
			pstmt.setString(1, accNumber);
			pstmt.setInt(2, user_id);
			pstmt.setDouble(3, 0.00);
			pstmt.setString(4, accountype);
			pstmt.setString(5, "active");

			
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
	
	public int depositMoney(String accountNumber, Integer user_id, Double amount) {

		int status = 0;
		if(amount <= 0) {
			return 0;
		}
		try {
			
			String sql = "update accounts set account_balance = account_balance+? where account_number=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			
			if(accountNumber != null && getAccountbyParam(null, accountNumber)!=null) {
				pstmt.setString(2, accountNumber);
			}else if(user_id != null) {
				List <Account> accountObjList = getAccountbyParam(user_id, null);
				for(int i=0;i<accountObjList.size();i++) {
					if(accountObjList.get(i).getAccount_type().equals("checking")) {
						pstmt.setString(2, accountObjList.get(i).getAccount_number());
					}
				}
				
			}
			System.out.println(pstmt);
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
	
	public int withdrawMoney(String accountNumber, Double amount) {
	
		int status = 0;
		if(amount <= 0) {
			return 0;
		}
		try {
			
			String sql = "update accounts set account_balance = account_balance-? where account_number=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//checking if account has balance to make the withdrawal
			if(accountNumber != null && getAccountbyParam(null, accountNumber)!=null) {
				List <Account> accountObjList = getAccountbyParam(null, accountNumber);
				for(int i=0;i<accountObjList.size();i++) {
					if(accountObjList.get(i).getAccount_balance()>=amount) {
						pstmt.setDouble(1, amount);
					}else {
						return -1;
					}
				}
				pstmt.setString(2, accountNumber);
			}
			
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

	public int transferMoney(String accountNumber, Integer user_id, double amount) {

		// TODO Auto-generated method stub
		int status = 0;
		if(amount<0) {
			return 0;
		}
		
		// Deducting from account
		int withdrawStaus = this.withdrawMoney(accountNumber, amount);
		if(withdrawStaus>0) {
			//Depositing in beneficiary account
			int depositStatus = this.depositMoney(null, user_id, amount);

			if(depositStatus >0) {
				status = 1;
			}
		}else if(withdrawStaus==-1) {
			status = -1;
		}
		return status;
	}
}
