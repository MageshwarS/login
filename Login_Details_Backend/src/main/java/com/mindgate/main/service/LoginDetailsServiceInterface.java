package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailsServiceInterface {

	public LoginDetails validate_login(LoginDetails login_Details);

	public List<LoginDetails> blockedUsers();

	public boolean resetCount(int loginId);

}
