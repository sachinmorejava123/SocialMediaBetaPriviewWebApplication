package com.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.daoI.RegisterDaoI;
import com.sm.daoImpl.RegisterDaoImpl;
import com.sm.dto.RegisterDto;



@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Creating object of RegisterDto class
	 RegisterDto registerDto=new RegisterDto();
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer=response.getWriter();
		//Getting parameter from register form
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		
		registerDto.setFname(fname);
		registerDto.setLname(lname);
		registerDto.setEmail(email);
		registerDto.setPassword(password);
		registerDto.setGender(gender);
		registerDto.setMobile(mobile);
		registerDto.setCountry(country);
		registerDto.setState(state);
		registerDto.setCity(city);
		registerDto.setAddress(address);
		registerDto.setPin(pin);
		
		RegisterDaoI registerDaoI=new RegisterDaoImpl();
		try {
			String msg=registerDaoI.insertUserInfo(registerDto);
			writer.println(msg);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			
	}
	
	
}
