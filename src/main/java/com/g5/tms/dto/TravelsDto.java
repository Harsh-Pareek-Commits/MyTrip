package com.g5.tms.dto;
import lombok.Data;

@Data
public class TravelsDto {

	private String travelsName;
	private String  agentName;
	private String  address;
	private String  contact;

	public String getTravelsName() {
		return travelsName;
	}
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "TravelsDto [travelsName=" + travelsName + ", agentName=" + agentName + ", address=" + address
				+ ", contact=" + contact + "]";
	}

}
