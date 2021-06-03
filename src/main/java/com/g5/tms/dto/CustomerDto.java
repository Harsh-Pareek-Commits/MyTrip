package com.g5.tms.dto;

public class CustomerDto {
	private int dtoUserId;
	private String dtoCustomerName;
	private String dtoAddress;
	private String dtoMobileNo;
	private String dtoEmail;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtoAddress == null) ? 0 : dtoAddress.hashCode());
		result = prime * result + ((dtoCustomerName == null) ? 0 : dtoCustomerName.hashCode());
		result = prime * result + ((dtoEmail == null) ? 0 : dtoEmail.hashCode());
		result = prime * result + ((dtoMobileNo == null) ? 0 : dtoMobileNo.hashCode());
		result = prime * result + dtoUserId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		if (dtoAddress == null) {
			if (other.dtoAddress != null)
				return false;
		} else if (!dtoAddress.equals(other.dtoAddress))
			return false;
		if (dtoCustomerName == null) {
			if (other.dtoCustomerName != null)
				return false;
		} else if (!dtoCustomerName.equals(other.dtoCustomerName))
			return false;
		if (dtoEmail == null) {
			if (other.dtoEmail != null)
				return false;
		} else if (!dtoEmail.equals(other.dtoEmail))
			return false;
		if (dtoMobileNo == null) {
			if (other.dtoMobileNo != null)
				return false;
		} else if (!dtoMobileNo.equals(other.dtoMobileNo))
			return false;
		if (dtoUserId != other.dtoUserId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerDto [dtoUserId=" + dtoUserId + ", dtoCustomerName=" + dtoCustomerName + ", dtoAddress="
				+ dtoAddress + ", dtoMobileNo=" + dtoMobileNo + ", dtoEmail=" + dtoEmail + "]";
	}
	

	
	
}