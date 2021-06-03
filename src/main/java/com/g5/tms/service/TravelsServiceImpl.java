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
	ITravelsRespository travels_repo;

	@Override
	@Transactional
	public Travels addTravels(Travels travels) {

		try {
			travels_repo.save(travels);
		} catch (Exception e) {
			log.error("Exception:", e);
		}
		return travels;
	}

	@Override
	@Transactional
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		Optional<Travels> opt = null;
		try {
			opt = travels_repo.findById(travels.getTravelsId());
			if (opt.isPresent()) {

				travels_repo.save(travels);
			} else {
				throw new TravelsNotFoundException("Travels cannot be updated");
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			throw new TravelsNotFoundException("Travels cannot be updated");
		}
		return opt.get();

	}

	@Override
	@Transactional
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt = null;
		try {
			opt = travels_repo.findById(travelsId);
			if (opt.isPresent()) {
			travels_repo.deleteById(travelsId);
			}
			 else {
					throw new TravelsNotFoundException("Travels cannot be updated");
				}
		} catch (Exception e) {
			log.error("Exception:", e);
			throw new TravelsNotFoundException("No travels found");

		}
		return opt.get();

	}

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {

		try {
			Optional<Travels>opt= travels_repo.findById(travelsId);
			if(opt.isPresent()) {
			return opt.get();
			}else {
				throw new TravelsNotFoundException("Travels Not foundin search travels");
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			throw new TravelsNotFoundException("Travels Not foundin search travels");
		}
	}

	@Override
	public List<Travels> viewTravels() {

		List<Travels> travel_list = null;
		try {

			travel_list = travels_repo.findAll();

		} catch (Exception e) {

			log.error("Exception:", e);
		}

		return travel_list;
	}
}
