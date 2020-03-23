package com.enquiry.pro.service;

import java.util.List;

import com.enquiry.pro.model.FollowUPRegister;

public interface IFollowRegService {

	public FollowUPRegister addFollowReg(FollowUPRegister followReg);
	public List<FollowUPRegister> viewFollowUpReg();
}
