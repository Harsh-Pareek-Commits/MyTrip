package com.g5.tms.dto;

import lombok.Data;

@Data

public class CustomerDto {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerMobileNo;
	private String customerEmail;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	

}