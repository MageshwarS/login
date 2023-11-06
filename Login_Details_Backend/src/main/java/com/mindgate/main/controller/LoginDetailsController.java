package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.LoginDetailsServiceInterface;

@RestController
@RequestMapping("logindetailsapi")
public class LoginDetailsController {

	@Autowired
	private LoginDetailsServiceInterface loginDetailsServiceInterface;
	
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public LoginDetails validateLogin(@RequestBody LoginDetails login_Details) {
		return loginDetailsServiceInterface.validate_login(login_Details);
	}
	
	@RequestMapping(value="inactiveusers", method = RequestMethod.GET)
	public List<LoginDetails> BlockedUsers(){
		return loginDetailsServiceInterface.blockedUsers();
	}
	
	@RequestMapping(value="reset/{loginId}", method = RequestMethod.PUT)
	public boolean updateStatus(@PathVariable int loginId) {
		return loginDetailsServiceInterface.resetCount(loginId);
	}
}
