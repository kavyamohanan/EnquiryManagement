package com.enquiry.pro.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.model.Payment;

public interface IPaymentRepo extends JpaRepositoryImplementation<Payment, Integer>{

}
