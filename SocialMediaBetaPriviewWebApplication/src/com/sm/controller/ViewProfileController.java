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
import com.sm.daoI.ViewProfileDaoI;
import com.sm.daoImpl.ViewProfileDaoImpl;
import com.sm.dto.ViewProfileDto;


@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ViewProfileDto viewProfileDto=new ViewProfileDto();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  writer=response.getWriter();
		HttpSession session=request.getSession();
		int regid=(int) session.getAttribute("regid");
		String fname=(String) session.getAttribute("fname");
		viewProfileDto.setRegid(regid);
		
		
		ViewProfileDaoI daoI=new ViewProfileDaoImpl();
		
		try {
			List<ViewProfileDto> list=daoI.viewProfile(viewProfileDto);
			
			JsonObject jsonObject=new JsonObject();
			
			String fname1=viewProfileDto.getFname();
			String lname=viewProfileDto.getLname();
			String email=viewProfileDto.getEmail();
			String gender=viewProfileDto.getGender();
			String mobile=viewProfileDto.getMobile();
			String country=viewProfileDto.getCountry();
			String state=viewProfileDto.getState();
			String city=viewProfileDto.getCity();
			String address=viewProfileDto.getAddress();
			int pin=viewProfileDto.getPin();
			
			
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
