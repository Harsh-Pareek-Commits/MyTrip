package com.g5.tms.entitydto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class HotelEntityDto {
	
	private int hotelId;
	
	@NotEmpty(message = "Hotel name cannot be left blank or null")
	@Size(min = 2,max = 10,message = "Invalid Hotel Name")
	private String hotelName;
	
	@NotEmpty(message = "Hotel Type cannot be left blank or null")
	@Size(min = 2,max = 20,message = "Invalid Hotel Type")
	private String hotelType;

	@Size(min = 10, max = 50, message 
    = "Hotel Description must be between 10 and 50 characters")
	private String hotelDescription;
	

	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 2,message = "Invalid Hotel Address")
	private String address;
	
	@Positive
	@Min(0)
	private double rent;
	
	@NotEmpty(message = "Hotel Status cannot be left blank or null")
	private String status;

	@NotEmpty(message = "City cannot be left blank or null")
	private String city;

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

}
