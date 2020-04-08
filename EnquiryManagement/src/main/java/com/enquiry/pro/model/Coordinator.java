package com.enquiry.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordinator {
	
	//instance variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coordinatorId;
	
	private String coordinatorName;
	private String username;
	private String password;
	
	//default constructor
	public Coordinator() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Integer coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
