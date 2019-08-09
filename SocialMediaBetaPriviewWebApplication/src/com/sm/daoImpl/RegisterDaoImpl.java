package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sm.daoI.RegisterDaoI;
import com.sm.dto.RegisterDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class RegisterDaoImpl implements RegisterDaoI {
	
	Connection connection=null;
	java.sql.PreparedStatement preparedStatement1=null;
	java.sql.PreparedStatement preparedStatement2=null;
	ResultSet resultSet=null;
	int count1=0,count2=0,reg_id=0;
	boolean flag=false;
	String msg;

	@Override
	public String insertUserInfo(RegisterDto registerDto) throws ClassNotFoundException, SQLException {
	    
		//Loading mysql driver class
		Class.forName("com.mysql.jdbc.Driver");
		//Getting db connection from DbConnection class
		connection=DbConnection.getConnection();
		//inserting user info into database
		preparedStatement1=connection.prepareStatement(SQLQueryConstant.INSERT_REGISTER_QUERY,Statement.RETURN_GENERATED_KEYS);
		 preparedStatement1.setString(1, registerDto.getFname());
		 preparedStatement1.setString(2, registerDto.getLname());
		 preparedStatement1.setString(3, registerDto.getEmail());
		 preparedStatement1.setString(4, registerDto.getPassword());
		 preparedStatement1.setString(5, registerDto.getGender());
		 preparedStatement1.setString(6, registerDto.getMobile());
		 preparedStatement1.setString(7, registerDto.getCountry());
		 preparedStatement1.setString(8, registerDto.getState());
		 preparedStatement1.setString(9, registerDto.getCity());
		 preparedStatement1.setString(10, registerDto.getAddress());
		 preparedStatement1.setInt(11, registerDto.getPin());
		 
		 count1=preparedStatement1.executeUpdate();
		 if(count1>0) {
			 resultSet=preparedStatement1.getGeneratedKeys();
			 resultSet.next();
			 reg_id=resultSet.getInt(1);
			 
			 preparedStatement2=connection.prepareStatement(SQLQueryConstant.INSERT_LOGIN_QUERY);
			 preparedStatement2.setString(1, registerDto.getEmail());
			 preparedStatement2.setString(2, registerDto.getPassword());
			 preparedStatement2.setInt(3, reg_id);
			 count2=preparedStatement2.executeUpdate();
			 
		 }
		 
		 if(count1>0 && count2>0) {
			 flag=true;
		 }else {
			 flag=false;
		 }
		 if(flag==true) {
			 msg="Hi.."+registerDto.getFname()+" your response saved successfully.";
		 }else {
			 msg="Hi.."+registerDto.getFname()+" your responce not saved please try again !";
		 }
		 return msg;
	}

}
