package com.g5.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	
	@ApiModelProperty(name = "HotelName", value = "Cannot be empty, holds min of 3  and max of 10 characters")
	@Column
	@NotEmpty(message = "Hotel name cannot be left blank or null")
	@Size(min = 2,message = "Invalid Hotel Name")
	private String hotelName;
	
	@ApiModelProperty(name = "HotelType", value = "Cannot be empty, holds min of 2 and max of 20 characters")
	@Column
	@NotEmpty(message = "Hotel Type cannot be left blank or null")
	@Size(min = 2,max = 20,message = "Invalid Hotel Type")
	private String hotelType;
	
	@ApiModelProperty(name = "HotelDescription", value = "Holds min of 10 and max of 50 characters")
	@Column
	@Size(min = 10, max = 50, message 
    = "Hotel Description must be between 10 and 50 characters")
	private String hotelDescription;
	
	@ApiModelProperty(name = "Adrress", value = "Contains hotel address, cannot be empty")
	@Column
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 2,message = "Invalid Hotel Address")
	private String address;
	
	@ApiModelProperty(name = "Rent", value = "Holds positive value")
	@Column
	@Positive
	@Min(0)
	private double rent;
	
	@ApiModelProperty(name = "Status", value = "Cannot be empty")
	@Column
	@NotEmpty(message = "Hotel Status cannot be left blank or null")
	private String status;
	@ApiModelProperty(name = "City", value = "Cannot be empty")
	@Column
	@NotEmpty(message = "City cannot be left blank or null")
	private String city;
	public Hotel() {
		super();

	}
	
	public Hotel(int hotelId,
			 String hotelName,
			String hotelType,
			String hotelDescription,
			String address,
			 double rent,
			String status,
			 String city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.address = address;
		this.rent = rent;
		this.status = status;
		this.city = city;
	}

	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public String getHotelDescription() {
		return hotelDescription;
	}
	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hotelId;
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
		Hotel other = (Hotel) obj;
		if (hotelId != other.hotelId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", address=" + address + ", rent=" + rent + ", status="
				+ status + ", city=" + city + "]";
	}
	
}
