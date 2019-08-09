package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sm.daoI.ForgotPasswordDaoI;
import com.sm.dto.ForgotPasswordDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class ForgotPasswordDaoImpl implements ForgotPasswordDaoI {

	Connection connection=null;
	PreparedStatement preparedStatement1=null;
	PreparedStatement preparedStatement2=null;
	PreparedStatement preparedStatement3=null;
	ResultSet resultSet=null;
	int regid,msg;
	boolean flag=false;
	int count1=0,count2=0;
	
	@Override
	public int forgotPassword(ForgotPasswordDto forgotPasswordDto) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection=DbConnection.getConnection();
		preparedStatement1=connection.prepareStatement(SQLQueryConstant.GET_REG_ID);
		preparedStatement1.setString(1, forgotPasswordDto.getEmail());
		resultSet=preparedStatement1.executeQuery();
		if(resultSet.next()) {
			regid=resultSet.getInt(1);
			
		   preparedStatement2=connection.prepareStatement(SQLQueryConstant.FORGOT_PASSWORD_REGISTER_QUERY);
		   preparedStatement2.setString(1, forgotPasswordDto.getPassword());
		   preparedStatement2.setInt(2, regid);
		   count1=preparedStatement2.executeUpdate();
		   
		   if(count1>0) {
			   
			   preparedStatement3=connection.prepareStatement(SQLQueryConstant.FORGOT_PASSWORD_LOGIN_QUERY);
			   preparedStatement3.setString(1, forgotPasswordDto.getPassword());
			   preparedStatement3.setInt(2, regid);
			   count2=preparedStatement3.executeUpdate();
			   
		   }
		   
		}
		
		
		
		if(count1>0 && count2>0) {
			 flag=true;
		}else {
			flag=false;
		}
		
		if(flag==true) {
			msg=1;
			
		}else {
			msg=2;
		}
		
		
		return msg;
	}

}