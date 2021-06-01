package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue(value = "3")
public class Customer extends User {


	@Column
	@NotEmpty(message = "Customer name cannot be left blank or null")
	@Size(min = 3,max = 20,message = "Invalid Customer Name")
	private String customerName;
	@Column
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5,message = "Invalid Address")
	private String address;
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp="(^$|[0-9]{10})", message ="Enter 10 digit mobile number")
	private String mobileNo;
	@Column
	@Email(message = "Enter valid email Id")
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, String address, String mobileNo, String email) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	
	}
	
	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", address=" + address + ", mobileNo=" + mobileNo + ", email="
				+ email + "]";
	}
	
	
	
	
}
