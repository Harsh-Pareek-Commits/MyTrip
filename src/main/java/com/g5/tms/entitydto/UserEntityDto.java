package com.g5.tms.entitydto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserEntityDto {
	private int userId;
	
	private String userType;
	@NotEmpty(message = "Password cannot be left blank or null")
	@Size(min = 8,message = "Invalid Password, Password should be min 8")
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
