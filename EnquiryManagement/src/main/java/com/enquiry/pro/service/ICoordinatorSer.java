package com.enquiry.pro.service;

import com.enquiry.pro.model.Coordinator;

public interface ICoordinatorSer {
	
	public Coordinator findByLoginCo(String username,String password);

}
