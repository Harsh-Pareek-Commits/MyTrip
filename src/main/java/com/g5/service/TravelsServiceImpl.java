package com.g5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.entities.Travels;
import com.g5.exceptions.TravelsNotFoundException;
import com.g5.repository.ITravelsRespository;
@Service
public class TravelsServiceImpl implements ITravelsService {
	
	@Autowired
	ITravelsRespository travels_repo;

	@Override
	@Transactional
	public Travels addTravels(Travels travels) {
	
			try 
			{
				travels_repo.save(travels);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			return travels;
		}

	@Override
	@Transactional
	public Travels updateTravels(Travels travels) throws TravelsNotFoundException {
		Optional<Travels> opt=null;
		try 
		{   
			opt=travels_repo.findById(travels.getTravelsId());
			travels_repo.save(travels);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new TravelsNotFoundException("Travels cannot be updated");
		}	
		return opt.get();
		
	}

	@Override
	@Transactional
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		Optional<Travels> opt=null;
		try {
			opt=travels_repo.findById(travelsId);
			travels_repo.deleteById(travelsId);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			throw new TravelsNotFoundException();
			
		}
		return opt.get();	

	}

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
	
		
		try {
			return travels_repo.findById(travelsId).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new TravelsNotFoundException("Travels Not foundin search travels");
		}
	}

	@Override
	public List<Travels> viewTravels() {
	
		List<Travels> travel_list = null;
		try {
			
			travel_list = travels_repo.findAll();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
		return travel_list;
	}
}
