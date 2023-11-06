package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.LoginDetails;

public class LoginDetailsRowMapper implements RowMapper<LoginDetails>{

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		int loginId = rs.getInt("login_id");
		String userName = rs.getString("username");
		String password = rs.getString("password");
		String role = rs.getString("role");
		int loginCount = rs.getInt("login_count");
		String loginStatus = rs.getString("login_status");
		LoginDetails login_Details = new LoginDetails(loginId, userName, password, loginCount, loginStatus, role);
		return login_Details;
	}

}
