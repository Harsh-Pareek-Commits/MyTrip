package com.g5.tms.entitydto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerEntityDto extends UserEntityDto {

	@NotEmpty(message = "Customer name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Customer Name")
	private String custName;

	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5, message = "Invalid Address")
	private String custAddress;

	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String custMobileNo;

	@Email(message = "Enter valid email Id")
	private String custEmail;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

}
