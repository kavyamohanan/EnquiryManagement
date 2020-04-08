package com.enquiry.pro.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.model.Coordinator;

public interface ICoordinatorRepo extends JpaRepositoryImplementation<Coordinator, Integer>{

	//for login with username and password
	@Query("from Coordinator where username=?1 and password=?2")
	Coordinator findByLogin(String username,String password);
	
	
}
