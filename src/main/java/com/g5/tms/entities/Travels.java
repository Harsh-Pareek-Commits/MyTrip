package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Travels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int travelsId;
	
	@ApiModelProperty(name = "TravelsName", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Travels name cannot be left blank or null")
	private String travelsName;
	
	@ApiModelProperty(name = "AgentName", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Agent name cannot be left blank or null")
	private String  agentName;
	
	@ApiModelProperty(name = "Address", value = "Cannot be empty, holds min of 2 characters")
	@Column
	@NotEmpty(message = "Address cannot be left blank or null")
	private String  address;
	
	@ApiModelProperty(name = "Contact", value = "Contains valid 10 digit mobile number")
	@Column
	@NotEmpty(message = "Contact number cannot be left blank or null")
	@Pattern(regexp="(^$|[0-9]{10})", message ="Enter 10 digit contact number")
	private String  contact;
	
	public Travels() {
		super();
	}
	public Travels(int travelsId, String travelsName, String agentName, String address, String contact) {
		super();
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}
	/**
	 * @return the travelsId
	 */
	public int getTravelsId() {
		return travelsId;
	}
	/**
	 * @param travelsId the travelsId to set
	 */
	public void setTravelsId(int travelsId) {
		this.travelsId = travelsId;
	}
	/**
	 * @return the travelsName
	 */
	public String getTravelsName() {
		return travelsName;
	}
	/**
	 * @param travelsName the travelsName to set
	 */
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
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
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + travelsId;
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
		Travels other = (Travels) obj;
		if (travelsId != other.travelsId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Travels [travelsId=" + travelsId + ", travelsName=" + travelsName + ", agentName=" + agentName
				+ ", address=" + address + ", contact=" + contact + "]";
	}
	
	
	
	
	
	
 
}
