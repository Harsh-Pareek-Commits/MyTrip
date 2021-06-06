package com.g5.tms.dto;


import lombok.Data;

@Data
public class AdminDto  {

	
	private String adminName;
	
	private String email;
	
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
		return "AdminDto [adminName=" + adminName + ", email=" + email + ", mobile=" + mobile + "]";
	}

	

}
