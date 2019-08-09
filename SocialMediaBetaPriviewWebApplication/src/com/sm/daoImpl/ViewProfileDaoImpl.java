package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.daoI.ViewProfileDaoI;
import com.sm.dto.ViewProfileDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class ViewProfileDaoImpl implements ViewProfileDaoI {
	Connection connection=null;
	PreparedStatement prepareStatement=null;
	ResultSet resultSet=null;
     ViewProfileDto viewProfileDto=new ViewProfileDto();
	@Override
	public List<ViewProfileDto> viewProfile(ViewProfileDto viewProfileDto) throws ClassNotFoundException, SQLException {
		ArrayList<ViewProfileDto> list=new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		connection=DbConnection.getConnection();
		prepareStatement=connection.prepareStatement(SQLQueryConstant.VIEW_PROFILE_QUERY);
		prepareStatement.setInt(1,viewProfileDto.getRegid());
		resultSet=prepareStatement.executeQuery();
		while(resultSet.next()) {
			viewProfileDto.setFname(resultSet.getString(1));
			viewProfileDto.setLname(resultSet.getString(2));
			viewProfileDto.setEmail(resultSet.getString(3));
			viewProfileDto.setGender(resultSet.getString(4));
			viewProfileDto.setMobile(resultSet.getString(5));
			viewProfileDto.setCountry(resultSet.getString(6));
			viewProfileDto.setState(resultSet.getString(7));
			viewProfileDto.setCity(resultSet.getString(8));
			viewProfileDto.setAddress(resultSet.getString(9));
			viewProfileDto.setPin(resultSet.getInt(10));
		}
		list.add(viewProfileDto);
		
		return list;
	}

}
