package com.g5.tms.dto;

public class TicketDetailsDto {

	private int ticketId;
	private String status;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TicketDetailsDto [ticketId=" + ticketId + ", status=" + status + "]";
	}
	

}
