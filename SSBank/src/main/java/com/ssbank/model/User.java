package com.ssbank.model;

import java.sql.Date;

public class User {
	private Integer user_id;
	private String fist_name;
	private String last_name;
	private Date dob;
	private String gender;
	private String email;
	private Integer phone_number;
	private String street_address;
	private String city;
	private String state;
	private String postal_code;
	private String nationality;
	private String password;
	public User(Integer user_id, String fist_name, String last_name, Date dob, String gender, String email,
			Integer phone_number, String street_address, String city, String state, String postal_code,
			String nationality, String password) {
		super();
		this.user_id = user_id;
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.nationality = nationality;
		this.password = password;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getFist_name() {
		return fist_name;
	}
	public void setFist_name(String fist_name) {
		this.fist_name = fist_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
