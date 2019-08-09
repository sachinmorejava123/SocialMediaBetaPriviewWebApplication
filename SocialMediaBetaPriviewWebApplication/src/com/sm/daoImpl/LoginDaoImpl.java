package com.sm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sm.daoI.LoginDaoI;
import com.sm.dto.LoginDto;
import com.sm.util.DbConnection;
import com.sm.util.SQLQueryConstant;

public class LoginDaoImpl implements LoginDaoI {
	
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	int regid;

	@Override
	public int loginUser(LoginDto loginDto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DbConnection.getConnection();
		preparedStatement=connection.prepareStatement(SQLQueryConstant.LOGIN_QUERY);
		preparedStatement.setString(1, loginDto.getEmail());
		preparedStatement.setString(2, loginDto.getPassword());
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			regid=resultSet.getInt(1);
			loginDto.setRegid(regid);
		}else {
			regid=0;
		}
		return regid;
	}

}
