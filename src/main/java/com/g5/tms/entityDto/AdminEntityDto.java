package com.g5.tms.entityDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AdminEntityDto extends UserEntityDto {
	
	@NotEmpty(message = "Admin name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Admin Name")
	private String adminName;
	@NotEmpty(message = "Email cannot be left blank or null")
	@Email(message = "Enter valid email Id")
	private String email;
	@NotEmpty(message = "MobileNo cannot be left blank or null")
	@Size(min = 10, max = 10, message = "Invalid Mobile Number")
	private String mobile;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "AdminEntityDto [adminName=" + adminName + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
