package com.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sm.daoImpl.UpdateProfileDaoImpl;
import com.sm.dto.UpdateProfileDto;



@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UpdateProfileDto updateProfileDto=new UpdateProfileDto();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		
		JsonObject jsonObject=new JsonObject();
		
		HttpSession session=request.getSession();
		int regid=(int) session.getAttribute("regid");
		
		updateProfileDto.setRegid(regid);
		
		UpdateProfileDaoImpl updateProfileDaoImpl=new UpdateProfileDaoImpl();
		
		try {
		   List<UpdateProfileDto> list= updateProfileDaoImpl.updateProfile(updateProfileDto);
			
		    String fname1=updateProfileDto.getFname();
			String lname=updateProfileDto.getLname();
			String email=updateProfileDto.getEmail();
			String gender=updateProfileDto.getGender();
			String mobile=updateProfileDto.getMobile();
			String country=updateProfileDto.getCountry();
			String state=updateProfileDto.getState();
			String city=updateProfileDto.getCity();
			String address=updateProfileDto.getAddress();
			int pin=updateProfileDto.getPin();
			
			jsonObject.addProperty("fname", fname1);
			jsonObject.addProperty("lname", lname);
			jsonObject.addProperty("email", email);
			jsonObject.addProperty("gender", gender);
			jsonObject.addProperty("mobile", mobile);
			jsonObject.addProperty("country", country);
			jsonObject.addProperty("state", state);
			jsonObject.addProperty("city", city);
			jsonObject.addProperty("address", address);
			jsonObject.addProperty("pin", pin);
			
			String json=jsonObject.toString();
			 writer.println(json);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
