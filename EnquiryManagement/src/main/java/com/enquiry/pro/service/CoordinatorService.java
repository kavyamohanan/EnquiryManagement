package com.enquiry.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.Coordinator;
import com.enquiry.pro.repository.ICoordinatorRepo;

@Service
public class CoordinatorService implements ICoordinatorSer{

	@Autowired
	private ICoordinatorRepo coRepo;
	
	@Override
	public Coordinator findByLoginCo(String username, String password) {
		
		return coRepo.findByLogin(username, password);
	}

}
