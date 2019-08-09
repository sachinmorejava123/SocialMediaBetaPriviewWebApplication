package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sm.daoI.UpdateUserInfoDaoI;
import com.sm.dto.UpdateUserInfoDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class UpdateUserInfoDaoImpl implements UpdateUserInfoDaoI {

	Connection connection=null;
	PreparedStatement preparedStatement1=null;
	PreparedStatement preparedStatement2=null;
	ResultSet resultSet=null;
	int count1=0,count2=0;
	Boolean flag=false;
	String msg;
	
	@Override
	public String updateUserInfo(UpdateUserInfoDto updateUserInfoDto) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection=DbConnection.getConnection();
		//Updatind user data from register table
		preparedStatement1=connection.prepareStatement(SQLQueryConstant.UPDATE_USER_INFO_QUERY);
		preparedStatement1.setString(1, updateUserInfoDto.getFname());
		preparedStatement1.setString(2, updateUserInfoDto.getLname());
		preparedStatement1.setString(3, updateUserInfoDto.getEmail());
		preparedStatement1.setString(4, updateUserInfoDto.getGender());
		preparedStatement1.setString(5, updateUserInfoDto.getMobile());
		preparedStatement1.setString(6, updateUserInfoDto.getCountry());
		preparedStatement1.setString(7, updateUserInfoDto.getState());
		preparedStatement1.setString(8, updateUserInfoDto.getCity());
		preparedStatement1.setString(9, updateUserInfoDto.getAddress());
		preparedStatement1.setInt(10, updateUserInfoDto.getPin());
		preparedStatement1.setInt(11, updateUserInfoDto.getRegid());
		count1=preparedStatement1.executeUpdate();
		
		//Updating user data from login table
		
		preparedStatement2=connection.prepareStatement(SQLQueryConstant.UPDATE_LOGIN_INFO_QUERY);
		preparedStatement2.setString(1, updateUserInfoDto.getEmail());
		preparedStatement2.setInt(2, updateUserInfoDto.getRegid());
		count2=preparedStatement2.executeUpdate();
		
		if(count1>0 && count2>0) {
			flag=true;
		}else {
			flag=false;
		}
		
		if(flag==true) {
			msg="Hi.."+updateUserInfoDto.getFname()+" your profile updated successfully";
		}else {
			msg="Hi.."+updateUserInfoDto.getFname()+" your profile updation failed";
		}
		
		return msg;
	}

}
