package com.ssbank.model;

public class Account {
	
	private String account_number;
	private String account_type;
	private Integer user_id;
	private Float account_balance;
	private String account_status;
	
	public Account(String account_number, String account_type, Integer user_id, Float account_balance,
			String account_status) {
		super();
		this.account_number = account_number;
		this.account_type = account_type;
		this.user_id = user_id;
		this.account_balance = account_balance;
		this.account_status = account_status;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Float getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(Float account_balance) {
		this.account_balance = account_balance;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
}
