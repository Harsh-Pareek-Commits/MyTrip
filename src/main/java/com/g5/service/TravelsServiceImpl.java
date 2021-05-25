package com.g5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.g5.entities.Travels;
import com.g5.exceptions.TravelsNotFoundException;
import com.g5.repository.ITravelsRespository;

public class TravelsServiceImpl implements ITravelsService {
	
	@Autowired
	ITravelsRespository travels_repo;

	@Override
	@Transactional
	public Travels addTravels(Travels travels) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		try 
		{
			travels_repo.save(travels);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new TravelsNotFoundException("Travels cannot be updated");
		}	
		return travels;
		
	}

	@Override
	public Travels removeTravels(int travelsId) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		try {
			Travels t=travels_repo.findById(travelsId).get();
			travels_repo.deleteById(travelsId);
			return t;	
			
		} catch (Exception e) {
			e.getStackTrace();
			throw new TravelsNotFoundException();
			// TODO: handle exception
		}

	}

	@Override
	public Travels searchTravels(int travelsId) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			return travels_repo.findById(travelsId).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new TravelsNotFoundException("Travels Not found");
		}
	}

	@Override
	public List<Travels> viewTravels() {
		// TODO Auto-generated method stub
		List<Travels> travel_list = null;
		try {
			
			travel_list = travels_repo.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return travel_list;
	}
}
