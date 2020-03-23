package com.enquiry.pro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.FollowUPRegister;
import com.enquiry.pro.repository.IFollowUPRegRepo;

@Service
public class FollowRegService implements IFollowRegService{

	@Autowired
	private IFollowUPRegRepo followRegRepo;
	
	@Transactional
	@Override
	public FollowUPRegister addFollowReg(FollowUPRegister followReg) {
		
		return followRegRepo.save(followReg);
	}

	@Override
	public List<FollowUPRegister> viewFollowUpReg() {
		// TODO Auto-generated method stub
		return followRegRepo.findAll();
	}

}
