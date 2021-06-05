package com.g5.tms.entityDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.g5.tms.entities.Bus;
import lombok.Data;


public class RouteEntityDto {
	
	
	private int routeId;
	private String  routeFrom;
	private String  routeTo;
	private  List<Bus> buses;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime  departureTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime   arrivalTime;
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate   doj;
	private String pickupPoint;
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
