package com.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.daoImpl.ForgotPasswordDaoImpl;
import com.sm.dto.ForgotPasswordDto;



@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		ForgotPasswordDto forgotPasswordDto=new ForgotPasswordDto();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		forgotPasswordDto.setEmail(email);
		forgotPasswordDto.setPassword(password);
		
		
		ForgotPasswordDaoImpl forgotPasswordDaoImpl=new ForgotPasswordDaoImpl();
		try {
			int msg=forgotPasswordDaoImpl.forgotPassword(forgotPasswordDto);
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
