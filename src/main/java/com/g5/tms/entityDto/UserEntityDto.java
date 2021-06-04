package com.g5.tms.entityDto;


public class UserEntityDto {
	private int userId;
	private String userType;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserEntityDto() {
		super();
	
	}
	

	@Override
	public String toString() {
		return "UserEntityDto [userId=" + userId + ", userType=" + userType + ", password=" + password + "]";
	}
	
	
}
