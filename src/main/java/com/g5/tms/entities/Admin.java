package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue(value = "2")
public class Admin extends User {
	
	@Column
	@NotEmpty(message = "Admin name cannot be left blank or null")
	@Size(min = 3,max = 20,message = "Invalid Admin Name")
	private String adminName;
	@Column
	@NotEmpty(message = "Email cannot be left blank or null")
	@Email(message = "Enter valid email Id")
	private String email;
	@Column
	@NotEmpty(message = "MobileNo cannot be left blank or null")
	@Size(min = 10,max = 10,message = "Invalid Mobile Number")
	private  String mobile;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminName, String email, String mobile) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.mobile = mobile;
		
	}
	
	
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}
