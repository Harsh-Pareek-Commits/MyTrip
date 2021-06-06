package com.g5.tms.entityDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerEntityDto extends UserEntityDto {
	
	@NotEmpty(message = "Customer name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Customer Name")
	private String customerName;
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5, message = "Invalid Address")
	private String address;
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobileNo;
	@Email(message = "Enter valid email Id")
	private String email;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerEntityDto [customerName=" + customerName + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", email=" + email + "]";
	}
	
	

}
