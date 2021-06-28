package com.g5.tms.entitydto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminEntityDto extends UserEntityDto {
	
	@NotEmpty(message = "Admin name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Admin Name")
	private String name;
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String adminMobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	@Override
	public String toString() {
		return "AdminEntityDto [name=" + name + ",adminMobile=" + adminMobile + "]";
	}

	
}
