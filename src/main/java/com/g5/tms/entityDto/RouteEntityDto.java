package com.g5.tms.entityDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import lombok.Data;


public class RouteEntityDto {
	
	
	private int routeId;
	@NotEmpty(message = "Route name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Origin")
	private String  routeFrom;
	@NotEmpty(message = "Route name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Destination")
	private String  routeTo;
	@Valid
	private  List<Bus> buses;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss" )
	private  LocalDateTime  departureTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Future(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss" )
	private  LocalDateTime   arrivalTime;
	  @Future(message = "Date cannot be past")
    @DateTimeFormat(pattern="yyyy-MM-dd" )
    @JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate   doj;
	  @NotEmpty(message = "Pickup point cannot be left blank or null")
		@Size(min = 2,max = 15,message = "Invalid pickup point")
	private String pickupPoint;
	  @Min(0)
		@Positive 
	private  double fare;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public List<Bus> getBuses() {
		return buses;
	}
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "RouteEntityDto [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", buses="
				+ buses + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj
				+ ", pickupPoint=" + pickupPoint + ", fare=" + fare + "]";
	}
}
