package com.g5.tms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.tms.entities.Travels;
import com.g5.tms.exceptions.TravelsNotFoundException;
import com.g5.tms.repository.ITravelsRespository;

@Service
public class TravelsServiceImpl implements ITravelsService {
	Logger log = LoggerFactory.getLogger(TravelsServiceImpl.class);
	@Autowired
	ITravelsRespository travelsRepository;

	@Override
	@Transactional
	public Travels addTravels(Travels travels) {

		try {
			travelsRepository.save(travels);
		} catch (Exception e) {
			log.error("Add travels Exception:", e);
		}
		return travels;
	}
	/*
	 *Author= Harshvardhan
	 *Date= 24-May-2021
	 *Method name: addTravels
	 *Parameters: Travels object
	 *Return Type: Travels object
	 *
	 **/

	@Override
	@Transactional
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		Optional<Travels> opt = null;
		try {
			opt = travelsRepository.findById(travels.getTravelsId());
			if (opt.isPresent()) {

				travelsRepository.save(travels);
			} else {
				throw new TravelsNotFoundException("Travels details not found");
			}
		} catch (Exception e) {
			
			throw new TravelsNotFoundException("Travels cannot be updated");
		}
		return opt.get();

	}
	/*
	 *Author= Harshvardhan
	 *Date= 24-May-2021
	 *Method name: updateTravels
	 *Parameters: TravelsId
	 *Return Type: Travels object
	 *
	 **/
	
	@Override
	@Transactional
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = null;
		try {
			opt = travelsRepository.findById(travelsId);
			if (opt.isPresent()) {
			travelsRepository.deleteById(travelsId);
			}
			 else {
					throw new TravelsNotFoundException("Travels id not found for delete");
				}
		} catch (Exception e) {
			
			throw new TravelsNotFoundException("No travels found");

		}
		return opt.get();

	}
	/*
	 *Author= Harshvardhan
	 *Date= 24-May-2021
	 *Method name: removeTravels
	 *Parameters: TravelsId
	 *Return Type: Travels object
	 *
	 **/

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {

		try {
			Optional<Travels>opt= travelsRepository.findById(travelsId);
			if(opt.isPresent()) {
			return opt.get();
			}else {
				throw new TravelsNotFoundException("Travels Not found in search travels");
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			throw new TravelsNotFoundException("Travels Not foundin search travels");
		}
	}
	/*
	 *Author= Harshvardhan
	 *Date= 24-May-2021
	 *Method name: searchTravels
	 *Parameters: TravelsId
	 *Return Type: Travels object
	 *
	 **/

	@Override
	public List<Travels> viewTravels() {

		List<Travels> travelList=null;
		try {

			travelList = travelsRepository.findAll();

		} catch (Exception e) {

			log.error("View travels Exception:", e);
		}

		return travelList;
	}
	/*
	 *Author= Harshvardhan
	 *Date= 24-May-2021
	 *Method name: searchTravels
	 *Return Type: Travels object
	 *
	 **/
}
