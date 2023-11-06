package com.mindgate.main.domain;

public class LoginDetails {

	private int LoginId;
	private String userName;
	private String password;
	private int loginCount;
	private String loginStatus;
	private String role;
	
	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(int loginId, String userName, String password, int loginCount, String loginStatus,
			String role) {
		super();
		LoginId = loginId;
		this.userName = userName;
		this.password = password;
		this.loginCount = loginCount;
		this.loginStatus = loginStatus;
		this.role = role;
	}

	public int getLoginId() {
		return LoginId;
	}

	public void setLoginId(int loginId) {
		LoginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDetails [LoginId=" + LoginId + ", userName=" + userName + ", password=" + password
				+ ", loginCount=" + loginCount + ", loginStatus=" + loginStatus + ", role=" + role + "]";
	}

	
	
	
}
