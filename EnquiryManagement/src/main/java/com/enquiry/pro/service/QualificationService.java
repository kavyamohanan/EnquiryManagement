package com.enquiry.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.Qualification;
import com.enquiry.pro.repository.IQualificationRepo;

@Service
public class QualificationService implements IQualificationService{

	
	//instance for repository
	@Autowired
	private IQualificationRepo qualRepo;
	
	
	//method to list all qualification
	@Override
	public List<Qualification> listQualification() {
		return qualRepo.findAll();
	}

}
