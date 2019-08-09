package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.daoI.UpdateProfileDaoI;
import com.sm.dto.UpdateProfileDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class UpdateProfileDaoImpl implements UpdateProfileDaoI {
	
	ArrayList<UpdateProfileDto> list=new ArrayList<>();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;

	public List<UpdateProfileDto> updateProfile(UpdateProfileDto updateProfileDto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DbConnection.getConnection();
		preparedStatement=connection.prepareStatement(SQLQueryConstant.UPDATE_PROFILE_QUERY);
		preparedStatement.setInt(1, updateProfileDto.getRegid());
		resultSet=preparedStatement.executeQuery();
		
		 
		while(resultSet.next()) {
			updateProfileDto.setFname(resultSet.getString(1));
			updateProfileDto.setLname(resultSet.getString(2));
			updateProfileDto.setEmail(resultSet.getString(3));
			updateProfileDto.setGender(resultSet.getString(4));
			updateProfileDto.setMobile(resultSet.getString(5));
			updateProfileDto.setCountry(resultSet.getString(6));
			updateProfileDto.setState(resultSet.getString(7));
			updateProfileDto.setCity(resultSet.getString(8));
			updateProfileDto.setAddress(resultSet.getString(9));
			updateProfileDto.setPin(resultSet.getInt(10));
			
			list.add(updateProfileDto);
		}
	    
		return list;
	}

}
