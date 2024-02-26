package com.TicketTrackerApplication.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


import com.TicketTrackerApplication.Model.TicketTrackerApplication;

@Service
public class TicketTrackerApplicationService {

	@Autowired
	TicketTrackerApplicationRepositery repo;

	public void insert(TicketTrackerApplication tiTrackerApplication) {
		repo.save(tiTrackerApplication);
	}

	public void update(TicketTrackerApplication tiTrackerApplication) {
		repo.save(tiTrackerApplication);
	}

	public List<TicketTrackerApplication> getAll() {
		return repo.findAll();
	}

	public void delete(TicketTrackerApplication tiTrackerApplication) {
		repo.delete(tiTrackerApplication);
	}

	public TicketTrackerApplication updateById(int id) {
		Optional<TicketTrackerApplication> optional = repo.findById(id);
		TicketTrackerApplication tiTrackerApplication = null;
		if (optional.get() != null) {
			tiTrackerApplication = optional.get();
		}
		return tiTrackerApplication;

	}
	public List<TicketTrackerApplication> filter(String searchkey)
	{
		//1.create a dummy object based on the searchkey
		TicketTrackerApplication dummy=new TicketTrackerApplication();
		dummy.setTickettitle(searchkey);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("tickettitle",ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","ticketshortdescription","ticketcreated","content");
		
Example<TicketTrackerApplication> example=Example.of(dummy,exampleMatcher);
		
		return repo.findAll(example);
	}
	public TicketTrackerApplication getById(int id)
	{
		if(repo.findById(id).isEmpty())
		{
			return null;
		}
		else
		{
			return repo.findById(id).get();
		}
		
	}
	
	
	

}

