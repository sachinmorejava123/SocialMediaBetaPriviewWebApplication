package com.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sm.daoImpl.UpdateUserInfoDaoImpl;
import com.sm.dto.UpdateUserInfoDto;



@WebServlet("/UpdateUserInfoController")
public class UpdateUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		UpdateUserInfoDto updateUserInfoDto=new UpdateUserInfoDto();
		HttpSession session=request.getSession();
		
		int regid=(int) session.getAttribute("regid");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		
		updateUserInfoDto.setRegid(regid);
		updateUserInfoDto.setFname(fname);
		updateUserInfoDto.setLname(lname);
		updateUserInfoDto.setEmail(email);
		updateUserInfoDto.setGender(gender);
		updateUserInfoDto.setMobile(mobile);
		updateUserInfoDto.setCountry(country);
		updateUserInfoDto.setState(state);
		updateUserInfoDto.setCity(city);
		updateUserInfoDto.setAddress(address);
		updateUserInfoDto.setPin(pin);
		
		UpdateUserInfoDaoImpl updateUserInfoDaoImpl=new UpdateUserInfoDaoImpl();
		try {
			String msg=updateUserInfoDaoImpl.updateUserInfo(updateUserInfoDto);
			writer.println(msg);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
