package com.g5.tms.entitydto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerEntityDto extends UserEntityDto {

	@NotEmpty(message = "Customer name cannot be left blank or null")
	private String custName;

	@NotEmpty(message = "Address cannot be left blank or null")
	private String custAddress;

	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String custMobileNo;

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


}
