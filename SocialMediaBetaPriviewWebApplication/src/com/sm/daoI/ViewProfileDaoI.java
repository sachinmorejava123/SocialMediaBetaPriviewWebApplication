package com.sm.daoI;

import java.sql.SQLException;
import java.util.List;

import com.sm.dto.ViewProfileDto;

public interface ViewProfileDaoI {
	public List<ViewProfileDto> viewProfile(ViewProfileDto dto) throws ClassNotFoundException, SQLException;

}
