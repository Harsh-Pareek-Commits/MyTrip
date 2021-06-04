package com.g5.tms.entityDto;
public class CustomerEntityDto extends UserEntityDto {
	private String customerName;
	private String address;
	private String mobileNo;
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
