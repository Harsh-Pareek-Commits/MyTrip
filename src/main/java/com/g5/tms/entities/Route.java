package com.g5.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;
	
	@ApiModelProperty(name = "RouteFrom", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Route name cannot be left blank or null")
	private String  routeFrom;
	
	@ApiModelProperty(name = "RouteTo", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Route name cannot be left blank or null")
	private String  routeTo;
	
	@ApiModelProperty(name = "Buses", value = "Contains bus list and information")
	@OneToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "Route_Bus", joinColumns = @JoinColumn(name = "routeId"),
	  inverseJoinColumns = @JoinColumn(name = "busId"))
	@Valid
	private  List<Bus> buses;
	
	@Column
	@ApiModelProperty(name = "DepartureDate", value = "Date cannot be past")
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate  departureDate;
	
	@Column
	@ApiModelProperty(name = "ArrivalDate", value = "Date cannot be past")
	@Future(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate   arrivalDate;
	
	@Column
	@ApiModelProperty(name = "ArrivalTime", value = "Contains arrival time")
	
	private  LocalTime   arrivalTime;
	
	@Column
	@ApiModelProperty(name = "DepartureTime", value = "Contains departure time")
	
	private  LocalTime   departureTime;
	
	@Column
	@ApiModelProperty(name = "Duration", value = "Time taken")
	private  String duration ;
	
	@ApiModelProperty(name = "PickUpPoint", value = "Cannot be empty, holds min of 2 and max of 15 characters")
	@Column
	@NotEmpty(message = "Pickup point cannot be left blank or null")
	private String pickupPoint;
	
	@ApiModelProperty(name = "Fare", value = "Holds positive value")
	@Column
	@Min(0)
	@Positive 
	private  double fare;

	public Route() {
		super();
	
	}

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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + routeId;
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
		Route other = (Route) obj;
		if (routeId != other.routeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", buses=" + buses
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", duration=" + duration + ", pickupPoint=" + pickupPoint
				+ ", fare=" + fare + "]";
	}

	public Route(int routeId,
			String routeFrom,
			 String routeTo, List<Bus> buses,
			LocalDate departureDate,
			 LocalDate arrivalDate, LocalTime arrivalTime,
			LocalTime departureTime, 
			 String pickupPoint,
		 double fare) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.buses = buses;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		
		this.pickupPoint = pickupPoint;
		this.fare = fare;
	}


}
