package com.enquiry.pro.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.model.Photo;

public interface IPhotoRepository extends JpaRepositoryImplementation<Photo, Integer>{

	
	@Modifying
	 @Query("update Photo p set p.registrationId=?1 where p.id = (select (max(p.id)))")
	//@Query("update Photo set registrationId=?1 ORDER BY id desc limit 1")
	void updateReg(Integer registrationId);
}