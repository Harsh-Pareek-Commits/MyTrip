package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.tms.entities.Feedback;
import com.g5.tms.entities.Hotel;
import com.g5.tms.entities.Package;
import com.g5.tms.exceptions.HotelNotFoundException;
import com.g5.tms.exceptions.PackageNotFoundException;
import com.g5.tms.repository.IHotelRepository;;
@Service
public class HotelServiceImpl implements IHotelService {
	
	Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);
	@Autowired
	IHotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) throws HotelNotFoundException {
		try {
	
			return hotelRepository.save(hotel);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new HotelNotFoundException("Hotel cannot be added");
		}
	}

	@Override
	public Hotel searchHotelbyName(String name) throws HotelNotFoundException {
		try {
			Optional<Hotel> opt = hotelRepository.findByName(name);
			if (opt.isPresent()) {
				return opt.get();
			} else {
				throw new HotelNotFoundException("Hotel Not Found in search by Name");
			}

		} catch (Exception e) {

			throw new HotelNotFoundException("Hotel Not Found in search by Name");

		}
	}

	@Override
	public List<Hotel> searchHotelbyCity(String city) throws HotelNotFoundException {
		List<Hotel> list =null;
		try {
			list = hotelRepository.findByCity(city);
		} catch (Exception e) {

			throw new HotelNotFoundException("Hotel Not Found in search by City");

		}
		return list;
	}

	@Override
	public List<Hotel> viewAll() {
		List<Hotel> hotelList = null;
		try {

			hotelList = hotelRepository.findAll();

		} catch (Exception e) {

			log.error("view all hotel Exception:", e);
		}

		return hotelList;
	}
	
	

}

