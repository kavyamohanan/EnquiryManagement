package com.enquiry.pro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FollowUPRegister {
	
	//instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flRegId;
	
	private Integer registrationId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate followUpDate = LocalDate.now();
	
	//private Integer coordinatorId;
	private Integer resourceId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate examDate;
	
	//default constructor
	public FollowUPRegister() {
		
	}

	public Integer getFlRegId() {
		return flRegId;
	}

	public void setFlRegId(Integer flRegId) {
		this.flRegId = flRegId;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}
	
	

}
