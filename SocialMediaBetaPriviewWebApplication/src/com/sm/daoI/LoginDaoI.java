package com.sm.daoI;

import java.sql.SQLException;

import com.sm.dto.LoginDto;

public interface LoginDaoI {
	public int loginUser(LoginDto loginDto) throws ClassNotFoundException, SQLException;

}
