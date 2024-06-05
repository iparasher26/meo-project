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
import com.opportunitypipeline.entity.Remarks;
import com.opportunitypipeline.service.RemarksService;

@RestController

public class RemarksController {
	
	@Autowired
	private RemarksService service;
	
	// POST METHOD : save, saveAll
	
	@PostMapping("/addRemark")
	public ResponseEntity<Remarks> addRemark(@RequestBody Remarks remark){
		service.saveRemark(remark);
		ResponseEntity<Remarks> anything = new ResponseEntity<Remarks>(remark, HttpStatus.CREATED);
		return anything;
	}
	
	@PostMapping("/addRemarks")
	public List<Remarks> addRemarks(@RequestBody List<Remarks> remarks){
		return service.saveRemarks(remarks);
	}
	
	// GET METHOD : get, getAll
	
	@GetMapping("/getRemarkById/{id}")
	public Remarks findRemark(@PathVariable int id){
		System.out.println("is it working? ");
		return service.getRemarkById(id);
	}
	
	@GetMapping("/getRemarks")
	public List<Remarks> findRemarks(){
		System.out.println("is it working? ");
		return service.getRemarks();
	}

}
