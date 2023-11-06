package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailsRepositoryInterface {
	
	public LoginDetails validate_login(LoginDetails login_Details);
	
	public List<LoginDetails> blockedUsers();
	
	public boolean resetCount(int loginId);
	
	public boolean incrementLoginCount(int loginId, int count);

}
