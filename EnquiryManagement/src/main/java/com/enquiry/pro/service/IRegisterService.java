package com.enquiry.pro.service;

import java.time.LocalDate;
import java.util.List;

import com.enquiry.pro.model.Registration;

public interface IRegisterService {
	
	public Registration addRegister(Registration register);
	public List<Registration> listRegistration();
	
	public void statusUpdate(int registrationId);
	public List<Registration> showNewRegisters(LocalDate registrationDate);
	
	

}
