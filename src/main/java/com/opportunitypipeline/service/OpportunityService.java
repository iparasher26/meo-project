package com.opportunitypipeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opportunitypipeline.entity.Opportunity;
import com.opportunitypipeline.repository.OpportunityRepository;

@Service

public class OpportunityService {
	
	@Autowired
	private OpportunityRepository repository;
	
	// POST METHOD : save, saveAll
	public Opportunity saveOpportunity(Opportunity opportunity){
		return repository.save(opportunity);
	}
	
	public List<Opportunity> saveOpportunities(List<Opportunity> opportunities){
		return repository.saveAll(opportunities);
	}
	
	// GET METHOD : fetch opportunity, fetchByName, fetchByStatus, fetchByOwner
	
	public Opportunity getOpportunityById(int id){
		return repository.findById(id).get();
	}
	
	public List<Opportunity> getOpportunities(){
		return repository.findAll();
	}
	
	public List<Opportunity> getOpportunitiesByName(String name){
		return repository.findByOpportunityName(name);
	}
	 
	public List<Opportunity> getOpportunitiesByStatus(String status){
		return repository.findByStatus(status);
	}
	
	public List<Opportunity> getOpportunitiesByOwner(String owner){
		return repository.findByOwner(owner);
	}
	
	// DELETE METHOD 
	public String deleteOpportunityById(int id){
		repository.deleteById(id);
		return "deleted opportunity id :"+id;
	}
	
	// PUT METHOD : updateOpportunity
	public Opportunity updateOpportunity(Opportunity update){
		Opportunity existingOpportunity = repository.findById(update.getId()).get();
		existingOpportunity.setOpportunityName(update.getOpportunityName());
		existingOpportunity.setTechnologyDomain(update.getTechnologyDomain());
		existingOpportunity.setDepartment(update.getDepartment());
		existingOpportunity.setOwner(update.getOwner());
		existingOpportunity.setStatus(update.getStatus());
		existingOpportunity.setCustomerDept(update.getCustomerDept());
		existingOpportunity.setCustomerName(update.getCustomerName());
		existingOpportunity.setCustomerContact(update.getCustomerContact());
		repository.save(existingOpportunity);
		return existingOpportunity;
	}

}
