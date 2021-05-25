package com.g5.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	@Column
	private  String busType;
	@Column
	private  String busNumber;
	@Column
	private int capacity;
	@OneToOne
	private Travels travel;
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int busId, String busType, String busNumber, int capacity, Travels travel) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.travel = travel;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Travels getTravel() {
		return travel;
	}
	public void setTravel(Travels travel) {
		this.travel = travel;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
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
		Bus other = (Bus) obj;
		if (busId != other.busId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ ", travel=" + travel + "]";
	}
	
	
	
	
	
}
