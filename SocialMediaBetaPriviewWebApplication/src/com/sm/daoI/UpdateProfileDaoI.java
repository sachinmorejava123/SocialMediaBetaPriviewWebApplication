package com.sm.daoI;

import java.sql.SQLException;
import java.util.List;

import com.sm.dto.UpdateProfileDto;

public interface UpdateProfileDaoI {
	
    public List<UpdateProfileDto> updateProfile(UpdateProfileDto updateProfileDto) throws ClassNotFoundException, SQLException;

}
