package com.enquiry.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.enquiry.pro.model.Qualification;
import com.enquiry.pro.service.IQualificationService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class QualificationController {

	@Autowired
	private IQualificationService qualService;

	// list all qualifications
	@GetMapping("qualifications")
	public ResponseEntity<List<Qualification>> getAllCourses() {

		return new ResponseEntity<List<Qualification>>(qualService.listQualification(), HttpStatus.OK);
	}

}
