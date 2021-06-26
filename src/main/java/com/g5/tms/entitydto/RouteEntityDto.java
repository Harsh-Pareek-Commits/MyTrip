package com.g5.tms.entitydto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.g5.tms.entities.Bus;



public class RouteEntityDto {
	
	private int routeId;
	@NotEmpty(message = "Route name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Origin")
	private String  from;
	@NotEmpty(message = "Route name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Destination")
	private String  to;
	@Valid
	private  List<Bus> buses;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss" )
	private  LocalDateTime  timeofDeparture;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Future(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss" )
	private  LocalDateTime   timeofArrival;
	
	private  String duration;
	  @NotEmpty(message = "Pickup point cannot be left blank or null")
		@Size(min = 2,max = 15,message = "Invalid pickup point")
	private String pickupPoint;
	  @Min(0)
		@Positive 
	private  double fareAmt;
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<Bus> getBuses() {
		return buses;
	}
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
	public LocalDateTime getTimeofDeparture() {
		return timeofDeparture;
	}
	public void setTimeofDeparture(LocalDateTime timeofDeparture) {
		this.timeofDeparture = timeofDeparture;
	}
	public LocalDateTime getTimeofArrival() {
		return timeofArrival;
	}
	public void setTimeofArrival(LocalDateTime timeofArrival) {
		this.timeofArrival = timeofArrival;
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public double getFareAmt() {
		return fareAmt;
	}
	public void setFareAmt(double fareAmt) {
		this.fareAmt = fareAmt;
	}
	@Override
	public String toString() {
		return "RouteEntityDto [routeId=" + routeId + ", from=" + from + ", to=" + to + ", buses=" + buses
				+ ", timeofDeparture=" + timeofDeparture + ", timeofArrival=" + timeofArrival + ", duration=" + duration
				+ ", pickupPoint=" + pickupPoint + ", fareAmt=" + fareAmt + "]";
	}

	
}
