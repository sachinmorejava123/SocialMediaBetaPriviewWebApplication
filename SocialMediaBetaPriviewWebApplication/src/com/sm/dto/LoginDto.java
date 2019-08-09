package com.sm.dto;

public class LoginDto {
  private int regid;
  private String email;
  private String password;
public int getRegid() {
	return regid;
}
public void setRegid(int regid) {
	this.regid = regid;
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
@Override
public String toString() {
	return "LoginDto [regid=" + regid + ", email=" + email + ", password=" + password + "]";
}
  
  
}
