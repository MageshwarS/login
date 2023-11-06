package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.LoginDetails;

@Repository
public class LoginDetailsRepository implements LoginDetailsRepositoryInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String SELECT_USER = "SELECT * FROM LOGIN_DETAILS_SPRINGBOOT WHERE LOGIN_ID = ? ";
	private String SELECT_BLOCKED_USERS = "select * from LOGIN_DETAILS_SPRINGBOOT where login_status ='blocked'";
	private String UPDATE_LOGIN_STATUS = "update LOGIN_DETAILS_SPRINGBOOT set login_status='active' where login_id=?";
	private String UPDATE_LOGIN_COUNT = "update LOGIN_DETAILS_SPRINGBOOT set login_count=?, login_status=? where login_id=?";

	@Override
	public LoginDetails validate_login(LoginDetails login_Details) {
		LoginDetailsRowMapper rowMapper = new LoginDetailsRowMapper();
		LoginDetails exisiting = jdbcTemplate.queryForObject(SELECT_USER, rowMapper, login_Details.getLoginId());
		return exisiting;
		
	}
	
	@Override
	public boolean incrementLoginCount(int loginId, int count){
		Object[] params = {count, count>=3?"blocked":"active" , loginId};
		int rownum = jdbcTemplate.update(UPDATE_LOGIN_COUNT, params);
		return rownum>0?true:false;
			
	}

	@Override
	public List<LoginDetails> blockedUsers() {
		LoginDetailsRowMapper rowMapper = new LoginDetailsRowMapper();
		List<LoginDetails> blockedusers= jdbcTemplate.query(SELECT_BLOCKED_USERS, rowMapper);
		return blockedusers;
	}

	@Override
	public boolean resetCount(int loginId) {
		int rowNum =jdbcTemplate.update(UPDATE_LOGIN_STATUS, loginId);
		if(rowNum>0)
			return true;
		else
			return false;
	}

}
