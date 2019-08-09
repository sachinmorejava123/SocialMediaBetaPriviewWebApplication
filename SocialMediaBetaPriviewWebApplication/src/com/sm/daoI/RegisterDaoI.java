package com.sm.daoI;

import java.sql.SQLException;

import com.sm.dto.RegisterDto;

public interface RegisterDaoI {
	public String insertUserInfo(RegisterDto registerDto) throws ClassNotFoundException, SQLException;
		
}
