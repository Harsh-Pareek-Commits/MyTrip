package com.g5.tms.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	@Column
	@NotEmpty(message = "Status cannot be left blank or null")
	private String status;

	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDetails(int ticketId, String status) {
		super();
		this.ticketId = ticketId;
		this.status = status;
	}

	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ticketId;
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
		TicketDetails other = (TicketDetails) obj;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", status=" + status + "]";
	}
	
	
	
	

}
