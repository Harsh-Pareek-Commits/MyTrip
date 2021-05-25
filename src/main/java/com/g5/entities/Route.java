package com.g5.entities;

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
	private String routeId;
	@Column
	private String  routeFrom;
	@Column
	private String  routeTo;
	@OneToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "Route_Bus", joinColumns = @JoinColumn(name = "routeId"),
	  inverseJoinColumns = @JoinColumn(name = "busId"))
	private  List<Bus> buses;
	@Temporal(TemporalType.DATE)
	private  LocalDateTime  departureTime;
	@Temporal(TemporalType.DATE)
	private  LocalDateTime   arrivalTime;
	@Temporal(TemporalType.DATE)
	private  LocalDate   doj;
	@Column
	private String pickupPoint;
	@Column
	private  double fare;
	
	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(String routeId, String routeFrom, String routeTo, List<Bus> buses, LocalDateTime departureTime,
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
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
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
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
