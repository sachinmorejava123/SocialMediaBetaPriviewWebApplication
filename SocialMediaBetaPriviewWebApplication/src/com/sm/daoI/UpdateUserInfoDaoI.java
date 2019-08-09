package com.sm.daoI;

import java.sql.SQLException;

import com.sm.dto.UpdateUserInfoDto;

public interface UpdateUserInfoDaoI {
	
	public String updateUserInfo(UpdateUserInfoDto updateUserInfoDto) throws ClassNotFoundException, SQLException;

}
