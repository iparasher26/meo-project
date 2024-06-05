package com.opportunitypipeline.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opportunitypipeline.entity.Opportunity;
import com.opportunitypipeline.entity.Remarks;
import com.opportunitypipeline.repository.RemarksRepository;

@Service

public class RemarksService {
	
	@Autowired
	private RemarksRepository repository;
	
	// POST METHOD : save, saveAll
		public Remarks saveRemark(Remarks remarks){
			return repository.save(remarks);
		}
		
		public List<Remarks> saveRemarks(List<Remarks> remarks){
			return repository.saveAll(remarks);
		}
		
	// GET METHOD : fetch, fetchByName, fetchByStatus, fetchByOwner
		
		public Remarks getRemarkById(int id){
			return repository.findById(id).get();
		}
		
		public List<Remarks> getRemarks(){
			return repository.findAll();
		}
		
}

