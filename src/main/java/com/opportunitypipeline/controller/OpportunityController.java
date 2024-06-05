package com.opportunitypipeline.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opportunitypipeline.entity.Opportunity;
import com.opportunitypipeline.service.OpportunityService;
@RestController

public class OpportunityController {

	@Autowired
	private OpportunityService service;
	
	@PostMapping("/addOpportunity")
	public ResponseEntity<Opportunity> addOpportunity(@RequestBody Opportunity opportunity){
		service.saveOpportunity(opportunity);
		ResponseEntity<Opportunity> anything = new ResponseEntity<Opportunity>(opportunity, HttpStatus.CREATED);
		return anything;
	}
	
	@PostMapping("/addOpportunities")
	public List<Opportunity> addOpportunities(@RequestBody List<Opportunity> opportunities){
		return service.saveOpportunities(opportunities);
	}
	
	// GET METHOD : fetch opportunity, fetchByName, fetchByStatus, fetchByOwner
	
	@GetMapping("/getOpportunities")
	public List<Opportunity> findOpportunities(){
		System.out.println("is it working? ");
		return service.getOpportunities();
	}
	
	@GetMapping("/getOpportunityById/{id}")
	public 	Opportunity findOpportunityById(@PathVariable int id){
		return service.getOpportunityById(id);
	}
	
	@GetMapping("/getOpportunitiesByName/{name}")
	public List<Opportunity> findOpportunityByName(@PathVariable String name) {
		return service.getOpportunitiesByName(name);	
	}
	
	@GetMapping("/getOpportunitiesByStatus/{status}")
	public List<Opportunity> findOpportunityByStatus(@PathVariable String status) {
		return service.getOpportunitiesByStatus(status);
	}
	
	@GetMapping("/getOpportunitiesByOwner/{owner}")
	public List<Opportunity> findOpportunityByOwner(String owner) {
		return service.getOpportunitiesByOwner(owner);
	}
	
	// DELETE METHOD : deleteOpportunityById
	@DeleteMapping("/deleteOpportunityById/{id}")
	public String deleteOpportunityById(@PathVariable int id){
		return service.deleteOpportunityById(id);
	}
			
	// PUT METHOD : updateOpportunity
	@PutMapping("/update")
	public Opportunity Update(@RequestBody Opportunity opportunity){
		return service.updateOpportunity(opportunity);
	}
}

//{
//    "opportunityName": "Homogolation",
//    "technologyDomain": "JAVA",
//    "owner": "Sumit Sahu",
//    "department": "I-GK-E",
//    "status": "HG0",
//    "customerName": "Audi",
//    "customerDept": "IDK",
//    "customerEntity": "IDK",
//    "customerCategory": "IDK",
//    "customerContact": "IDK@gmail.com"
//}
