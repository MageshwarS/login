package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.repository.LoginDetailsRepositoryInterface;

@Service
public class LoginDetailsService implements LoginDetailsServiceInterface {

	@Autowired
	private LoginDetailsRepositoryInterface detailsRepositoryInterface;

	@Override
	public LoginDetails validate_login(LoginDetails loginDetails) {

		LoginDetails existing = detailsRepositoryInterface.validate_login(loginDetails);

//		return existing;
		if (existing.getLoginStatus().equalsIgnoreCase("active") && existing.getLoginCount() < 3) {
			if (existing.getPassword().equals(loginDetails.getPassword())) {
				detailsRepositoryInterface.incrementLoginCount(existing.getLoginId(), 0);
				existing.setLoginCount(0);
				existing.setPassword("");
				return existing;
			} else {
				detailsRepositoryInterface.incrementLoginCount(existing.getLoginId(), existing.getLoginCount() + 1);
				loginDetails.setLoginCount(existing.getLoginCount() + 1);
				loginDetails.setPassword("");
				loginDetails.setLoginStatus(existing.getLoginStatus());
				return loginDetails;
			}
		} else {
			loginDetails.setLoginCount(existing.getLoginCount());
			loginDetails.setPassword("");
			loginDetails.setLoginStatus(existing.getLoginStatus());
			return loginDetails;
		}

	}

	@Override
	public List<LoginDetails> blockedUsers() {
		List<LoginDetails> blockedusers =detailsRepositoryInterface.blockedUsers();
		for (LoginDetails loginDetails : blockedusers) {
			loginDetails.setPassword("");
		}
		return blockedusers;
	}

	@Override
	public boolean resetCount(int loginId) {
		// TODO Auto-generated method stub
		return detailsRepositoryInterface.resetCount(loginId);
	}

}
