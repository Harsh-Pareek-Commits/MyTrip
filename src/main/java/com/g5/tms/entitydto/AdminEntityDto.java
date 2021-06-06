package com.g5.tms.entitydto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AdminEntityDto extends UserEntityDto {
	
	@NotEmpty(message = "Admin name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Admin Name")
	private String name;
	@NotEmpty(message = "Email cannot be left blank or null")
	@Email(message = "Enter valid email Id")
	private String adminEmail;
	@NotEmpty(message = "MobileNo cannot be left blank or null")
	@Size(min = 10, max = 10, message = "Invalid Mobile Number")
	private String adminMobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	@Override
	public String toString() {
		return "AdminEntityDto [name=" + name + ", adminEmail=" + adminEmail + ", adminMobile=" + adminMobile + "]";
	}

}
