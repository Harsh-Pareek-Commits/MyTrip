package com.g5.tms.entitydto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

import io.swagger.annotations.ApiModelProperty;



public class RouteEntityDto {
	
	private int routeId;
	@NotEmpty(message = "Route name cannot be left blank or null")
	private String  from;
	@NotEmpty(message = "Route name cannot be left blank or null")
	private String  to;
	@Valid
	private  List<Bus> buses;
	@ApiModelProperty(name = "DepartureDate", value = "Departure Date cannot be past")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate  departureDate;
	
	@ApiModelProperty(name = "ArrivalDate", value = "Arrival Date cannot be past")
	@Future(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate   arrivalDate;
	
	@ApiModelProperty(name = "ArrivalTime", value = "Contains arrival time")
	
	private  LocalTime   arrivalTime;
	
	@ApiModelProperty(name = "DepartureTime", value = "Contains departure time")

	private  LocalTime   departureTime;

	private  String duration;
	  @NotEmpty(message = "Pickup point cannot be left blank or null")
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
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
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
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", duration=" + duration + ", pickupPoint=" + pickupPoint
				+ ", fareAmt=" + fareAmt + "]";
	}
	
	  
}
