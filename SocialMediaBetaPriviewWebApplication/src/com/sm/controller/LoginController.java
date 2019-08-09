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

import com.sm.daoI.LoginDaoI;
import com.sm.daoImpl.LoginDaoImpl;
import com.sm.dto.LoginDto;



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    LoginDto loginDto=new LoginDto();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		loginDto.setEmail(email);
		loginDto.setPassword(password);
		
		LoginDaoI daoI=new LoginDaoImpl();
		try {
			int regid=daoI.loginUser(loginDto);
			HttpSession session=request.getSession();
			session.setAttribute("regid", regid);
			session.setAttribute("fname",loginDto.getEmail());
			writer.println(regid);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
