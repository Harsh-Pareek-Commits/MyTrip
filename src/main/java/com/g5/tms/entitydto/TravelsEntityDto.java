package com.g5.tms.entitydto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class TravelsEntityDto {
	
	private int travelsId;
	@NotEmpty(message = "Travels name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid travels Name")
	private String travelsName;
	@NotEmpty(message = "Agent name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid agent Name")
	private String  agentName;
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 2,message = "Invalid address")
	private String  agentsAddress;
	@NotEmpty(message = "Contact number cannot be left blank or null")
	@Pattern(regexp="(^$|[0-9]{10})", message ="Enter 10 digit contact number")
	private String  agentsContact;
	

	public int getTravelsId() {
		return travelsId;
	}
	public void setTravelsId(int travelsId) {
		this.travelsId = travelsId;
	}
	
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
	public String getAgentsAddress() {
		return agentsAddress;
	}
	public void setAgentsAddress(String agentsAddress) {
		this.agentsAddress = agentsAddress;
	}
	public String getAgentsContact() {
		return agentsContact;
	}
	public void setAgentsContact(String agentsContact) {
		this.agentsContact = agentsContact;
	}
	@Override
	public String toString() {
		return "TravelsEntityDto [travelsId=" + travelsId + ", travelsName=" + travelsName + ", agentName=" + agentName
				+ ", agentsAddress=" + agentsAddress + ", agentsContact=" + agentsContact + "]";
	}
	

}
