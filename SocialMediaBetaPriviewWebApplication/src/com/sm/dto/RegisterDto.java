package com.sm.dto;

public class RegisterDto {
	//Declaration of fields
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String gender;
	private String mobile;
	private String country;
	private String state;
	private String city;
	private String address;
	private int pin;
	
	//setter and getter of above fields
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	//toString method of above fields
	
	@Override
	public String toString() {
		return "RegisterDto [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", mobile=" + mobile + ", country=" + country + ", state=" + state + ", city="
				+ city + ", address=" + address + ", pin=" + pin + "]";
	}
	
	
	
	
	
	
	

}
