package com.enquiry.pro.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.dto.ViewRegister;
import com.enquiry.pro.model.Registration;


public interface IRegistrationRepo extends JpaRepositoryImplementation<Registration, Integer>{

	@Modifying
	@Query("update Registration set status='Informed' where registrationId=?1")
	void updateStatus(Integer registrationId);
	
	@Query("from Registration where registrationDate >= ?1")
	List<Registration> findByDate(LocalDate registrationDate );
	
	//@Query("select new com.enquiry.pro.dto.ViewRegister(r.registrationId,r.registrationDate,r.name,r.address,r.district,r.state,r.pincode,r.nationality,r.phone,r.gender,r.dob,r.email,r.courseId,r.photo,r.status,r.qualificationID)from MultipleQualification join Registration using registrationId join payment using registrationId where registrationId=?1")
	//List<ViewRegister> findByRegId(Integer registrationId);
	
}
