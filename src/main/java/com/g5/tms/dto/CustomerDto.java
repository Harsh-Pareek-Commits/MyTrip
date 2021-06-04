package com.g5.tms.dto;
public class CustomerDto {
	private int dtoUserId;
	private String dtoCustomerName;
	private String dtoAddress;
	private String dtoMobileNo;
	private String dtoEmail;
	
	/**
	 * @return the dtoUserId
	 */
	public int getDtoUserId() {
		return dtoUserId;
	}
	/**
	 * @param dtoUserId the dtoUserId to set
	 */
	public void setDtoUserId(int dtoUserId) {
		this.dtoUserId = dtoUserId;
	}
	/**
	 * @return the dtoCustomerName
	 */
	public String getDtoCustomerName() {
		return dtoCustomerName;
	}
	/**
	 * @param dtoCustomerName the dtoCustomerName to set
	 */
	public void setDtoCustomerName(String dtoCustomerName) {
		this.dtoCustomerName = dtoCustomerName;
	}
	/**
	 * @return the dtoAddress
	 */
	public String getDtoAddress() {
		return dtoAddress;
	}
	/**
	 * @param dtoAddress the dtoAddress to set
	 */
	public void setDtoAddress(String dtoAddress) {
		this.dtoAddress = dtoAddress;
	}
	/**
	 * @return the dtoMobileNo
	 */
	public String getDtoMobileNo() {
		return dtoMobileNo;
	}
	/**
	 * @param dtoMobileNo the dtoMobileNo to set
	 */
	public void setDtoMobileNo(String dtoMobileNo) {
		this.dtoMobileNo = dtoMobileNo;
	}
	/**
	 * @return the dtoEmail
	 */
	public String getDtoEmail() {
		return dtoEmail;
	}
	/**
	 * @param dtoEmail the dtoEmail to set
	 */
	public void setDtoEmail(String dtoEmail) {
		this.dtoEmail = dtoEmail;
	}
	public CustomerDto() {
		super();
		
	}
	public CustomerDto(int dtoUserId, String dtoCustomerName, String dtoAddress, String dtoMobileNo, String dtoEmail) {
		super();
		this.dtoUserId = dtoUserId;
		this.dtoCustomerName = dtoCustomerName;
		this.dtoAddress = dtoAddress;
		this.dtoMobileNo = dtoMobileNo;
		this.dtoEmail = dtoEmail;
	}
	
	@Override
	public String toString() {
		return "CustomerDto [dtoUserId=" + dtoUserId + ", dtoCustomerName=" + dtoCustomerName + ", dtoAddress="
				+ dtoAddress + ", dtoMobileNo=" + dtoMobileNo + ", dtoEmail=" + dtoEmail + "]";
	}
	

	
	
}