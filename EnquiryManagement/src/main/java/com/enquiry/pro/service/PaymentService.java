package com.enquiry.pro.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.Payment;
import com.enquiry.pro.repository.IPaymentRepo;

@Service
public class PaymentService implements IPaymentService{

	@Autowired
	private IPaymentRepo paymentRepo;
	
	//add payments
	@Transactional
	@Override
	public Payment addPayment(Payment payment) {
		
		return paymentRepo.save(payment);
	}

}
