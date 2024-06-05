package com.opportunitypipeline.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@jakarta.persistence.Table(name="opportunityTable")

public class Opportunity {
	@Id
	@GeneratedValue
	private int id; //primary-key
	private String opportunityName;
	private String technologyDomain;
	private String owner;
	private String department;
	private String status;
	private String customerName;	
	private String customerDept;
	private String customerEntity;
	private String customerCategory;
	private String customerContact;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Remarks.class)
	@JoinColumn(name = "remark-to-opportunity", referencedColumnName = "id")
	private List<Remarks> remark ;
	
	public List<Remarks> getRemark() {
		return remark;
	}
	public void setRemark(List<Remarks> remark) {
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpportunityName() {
		return opportunityName;
	}
	public void setOpportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}
	public String getTechnologyDomain() {
		return technologyDomain;
	}
	public void setTechnologyDomain(String technologyDomain) {
		this.technologyDomain = technologyDomain;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDept() {
		return customerDept;
	}
	public void setCustomerDept(String customerDept) {
		this.customerDept = customerDept;
	}
	public String getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(String customerEntity) {
		this.customerEntity = customerEntity;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
}



