package com.opportunitypipeline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opportunitypipeline.entity.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

	List<Opportunity> findByOwner(String owner);

	List<Opportunity> findByOpportunityName(String name);

	List<Opportunity> findByStatus(String status);

}
