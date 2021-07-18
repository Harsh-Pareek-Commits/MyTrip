package com.g5.tms.service;

import java.util.List;

import com.g5.tms.entities.Hotel;
import com.g5.tms.exceptions.HotelNotFoundException;

public interface IHotelService {
	
	public Hotel addHotel (Hotel hotel ) throws HotelNotFoundException;
	public Hotel searchHotelbyName(String name) throws HotelNotFoundException;
	public List<Hotel> searchHotelbyCity(String city) throws HotelNotFoundException;
	public List<Hotel> viewAll();
	public Hotel getHotelByid(int id)throws HotelNotFoundException;
	public  Hotel  deleteHotel(int hotelId) throws HotelNotFoundException;
}
