package com.g5.tms.dto;


import lombok.Data;

@Data
public class AdminDto  {
	private int adminId;
	
	private String email;
	private String adminName;

	private String mobile;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", email=" + email + ", adminName=" + adminName + ", mobile=" + mobile
				+ "]";
	}

	

}
