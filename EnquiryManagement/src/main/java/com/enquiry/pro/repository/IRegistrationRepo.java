package com.enquiry.pro.repository;



import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.model.Registration;


public interface IRegistrationRepo extends JpaRepositoryImplementation<Registration, Integer>{

}
