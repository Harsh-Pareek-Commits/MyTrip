package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "3")
public class Customer extends User {

	
	@ApiModelProperty(name = "CustomerName", value = "Cannot be null, holds min of 3 characters and max of 20 characters")
	@Column
	@NotEmpty(message = "Customer name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Customer Name")
	private String customerName;
	
	@ApiModelProperty(name = "Address", value = "Cannot be null, holds min of 5 characters")
	@Column
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5, message = "Invalid Address")
	private String address;
	
	@ApiModelProperty(name = "MobileNumber", value = "Cannot be null, should be valid 10 digit mobile number")
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobileNo;
	
	@ApiModelProperty(name = "Email", value = "Holds email id")
	@Column
	@Email(message = "Enter valid email Id")
	private String email;

	public Customer() {
		super();

	}

	public Customer(String customerName, String address, String mobileNo, String email) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;

	}

	

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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", address=" + address + ", mobileNo=" + mobileNo + ", email="
				+ email + "]";
	}
}
