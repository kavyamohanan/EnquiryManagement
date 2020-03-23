package com.enquiry.pro.service;

import java.util.List;

import com.enquiry.pro.model.Registration;

public interface IRegisterService {
	
	public Registration addRegister(Registration register);
	public List<Registration> listRegistration();
	
	//public String updateStatus(int registrationId);

}
