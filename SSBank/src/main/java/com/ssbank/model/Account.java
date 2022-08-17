package com.ssbank.model;

public class Account {
	
	private String account_number;
	private Integer user_id;
	private Double account_balance;
	private String account_type;
	private String account_status;
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	public Account(String account_number, Integer user_id, Double account_balance, String account_type,
			String account_status) {
		super();
		this.account_number = account_number;
		this.user_id = user_id;
		this.account_balance = account_balance;
		this.account_type = account_type;
		this.account_status = account_status;
	}
	
}
