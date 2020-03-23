package com.enquiry.pro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.Registration;
import com.enquiry.pro.repository.IRegistrationRepo;

@Service
public class RegisterService implements IRegisterService{

	//instance for register repository
	@Autowired
	private IRegistrationRepo registerRepo;
	
	
	//method to add registration details
	@Transactional
	@Override
	public Registration addRegister(Registration register) {
		
		return registerRepo.save(register);
	}


	//list all registration
	@Override
	public List<Registration> listRegistration() {

		return registerRepo.findAll();
	}


	

}
