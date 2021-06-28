package com.g5.tms.entitydto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserEntityDto {
	
	private int userId;
	
	private String userType;
	
	@NotEmpty(message = "Password cannot be left blank or null")
	@Size(min = 8,message = "Invalid Password, Password should be min 8")
	private String password;
	@NotEmpty(message = "Email number cannot be left blank or null")
	@Email(message = "Enter valid email Id")
	private String userEmail;
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "UserEntityDto [userId=" + userId + ", userType=" + userType + ", password=" + password + ", userEmail="
				+ userEmail + "]";
	}
	
}
