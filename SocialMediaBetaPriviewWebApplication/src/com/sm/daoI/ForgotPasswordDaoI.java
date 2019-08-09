package com.sm.daoI;

import java.sql.SQLException;

import com.sm.dto.ForgotPasswordDto;

public interface ForgotPasswordDaoI {
	
	public int forgotPassword(ForgotPasswordDto forgotPasswordDto) throws ClassNotFoundException, SQLException;

}
