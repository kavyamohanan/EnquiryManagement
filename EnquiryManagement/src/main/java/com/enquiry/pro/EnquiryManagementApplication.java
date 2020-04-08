package com.enquiry.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enquiry.pro.model.FollowUPRegister;
import com.enquiry.pro.model.Registration;

@SpringBootApplication
public class EnquiryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquiryManagementApplication.class, args);
		System.out.println("Running............ ");
		
		FollowUPRegister follow = new FollowUPRegister();
		System.out.println(follow.getFollowUpDate());
		
		Registration reg = new Registration();
		System.out.println(reg.getPhoto());
		
	}

}
