package com.g5.tms.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;
	@Column
	private String  routeFrom;
	@Column
	private String  routeTo;
	@OneToMany(cascade = CascadeType.PERSIST)
	  @JoinTable(name = "Route_Bus", joinColumns = @JoinColumn(name = "routeId"),
	  inverseJoinColumns = @JoinColumn(name = "busId"))
	private  List<Bus> buses;
	
	private  LocalDateTime  departureTime;
	
	private  LocalDateTime   arrivalTime;

	private  LocalDate   doj;
	@Column
	private String pickupPoint;
	@Column
	private  double fare;
	
	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(int routeId, String routeFrom, String routeTo, List<Bus> buses, LocalDateTime departureTime,
			LocalDateTime arrivalTime, LocalDate doj, String pickupPoint, double fare) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.buses = buses;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
	}
	
	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the routeFrom
	 */
	public String getRouteFrom() {
		return routeFrom;
	}
	/**
	 * @param routeFrom the routeFrom to set
	 */
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	/**
	 * @return the routeTo
	 */
	public String getRouteTo() {
		return routeTo;
	}
	/**
	 * @param routeTo the routeTo to set
	 */
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	/**
	 * @return the buses
	 */
	public List<Bus> getBuses() {
		return buses;
	}
	/**
	 * @param buses the buses to set
	 */
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
	/**
	 * @return the departureTime
	 */
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the arrivalTime
	 */
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the doj
	 */
	public LocalDate getDoj() {
		return doj;
	}
	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	/**
	 * @return the pickupPoint
	 */
	public String getPickupPoint() {
		return pickupPoint;
	}
	/**
	 * @param pickupPoint the pickupPoint to set
	 */
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
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
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj
				+ ", pickupPoint=" + pickupPoint + ", fare=" + fare + "]";
	}
	
	

}
