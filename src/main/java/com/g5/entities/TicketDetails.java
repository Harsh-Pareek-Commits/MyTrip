package com.g5.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketDetails {
	
	private String ticketId;
	
	private String status;

	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDetails(String ticketId, String status) {
		super();
		this.ticketId = ticketId;
		this.status = status;
	}

	/**
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(String ticketId) {
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
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
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
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", status=" + status + "]";
	}
	
	
	
	

}
