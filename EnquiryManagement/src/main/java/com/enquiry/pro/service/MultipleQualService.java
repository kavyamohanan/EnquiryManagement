package com.enquiry.pro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.MultipleQualification;
import com.enquiry.pro.repository.IMutilpleQualRepo;

@Service
public class MultipleQualService implements IMultipleQualService{

	@Autowired
	private IMutilpleQualRepo multQualRepo;
	
	//adding qualifications 
	@Transactional
	@Override
	public MultipleQualification addMulQulaification(MultipleQualification mulQual) {
		return multQualRepo.save(mulQual);
	}

	//listing qualifications
	@Override
	public List<MultipleQualification> listMulQual() {
		
		return multQualRepo.findAll();
	}

}
