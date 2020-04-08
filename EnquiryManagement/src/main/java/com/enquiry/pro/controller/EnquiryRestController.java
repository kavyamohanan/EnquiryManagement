package com.enquiry.pro.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enquiry.pro.model.Coordinator;
import com.enquiry.pro.model.Course;
import com.enquiry.pro.model.FollowUPRegister;
import com.enquiry.pro.model.MultipleQualification;
import com.enquiry.pro.model.Payment;
import com.enquiry.pro.model.Registration;
import com.enquiry.pro.service.ICoordinatorSer;
import com.enquiry.pro.service.ICourseService;
import com.enquiry.pro.service.IFollowRegService;
import com.enquiry.pro.service.IMultipleQualService;
import com.enquiry.pro.service.IPaymentService;
import com.enquiry.pro.service.IRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class EnquiryRestController {
	

	// instance for ICourse Service
	@Autowired
	private ICourseService courseSer;

	// list all courses
	@GetMapping("courses")
	public ResponseEntity<List<Course>> getAllCourses() {

		return new ResponseEntity<List<Course>>(courseSer.courseList(), HttpStatus.OK);
	}

	// instance for registration service----------------
	@Autowired
	private IRegisterService registerSer;

	// add registration details
	@PostMapping("/register")
	public ResponseEntity<Registration> addRegister(@RequestBody Registration register) {
		return new ResponseEntity<Registration>(registerSer.addRegister(register), HttpStatus.OK);
	}

	// view all registration details
	@GetMapping("registers")
	public ResponseEntity<List<Registration>> getAllRegisters() {

		return new ResponseEntity<List<Registration>>(registerSer.listRegistration(), HttpStatus.OK);
	}

	// instance for multiple qualification service
	@Autowired
	private IMultipleQualService mulQualSer;

	// add qualification details
	@PostMapping("mulqualification")
	public ResponseEntity<MultipleQualification> addMulQuals(@RequestBody MultipleQualification mulQual) {
		return new ResponseEntity<MultipleQualification>(mulQualSer.addMulQulaification(mulQual), HttpStatus.OK);
	}

	// view all qualification details
	@GetMapping("mulqualifications")
	public ResponseEntity<List<MultipleQualification>> getAllQualification() {

		return new ResponseEntity<List<MultipleQualification>>(mulQualSer.listMulQual(), HttpStatus.OK);
	}

	// instance for Payment Service
	@Autowired
	private IPaymentService paySer;

	// adding payment
	@PostMapping("payment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paySer.addPayment(payment), HttpStatus.OK);
	}

	// adding followUp Registration
	@Autowired
	private IFollowRegService folRegSer;

	@PostMapping("followupregister")
	public ResponseEntity<FollowUPRegister> addFollowReg(@RequestBody FollowUPRegister followReg) {
		return new ResponseEntity<FollowUPRegister>(folRegSer.addFollowReg(followReg), HttpStatus.OK);
	}

	// view all qualification details
	@GetMapping("followupregisters")
	public ResponseEntity<List<FollowUPRegister>> viewFollowReg() {

		return new ResponseEntity<List<FollowUPRegister>>(folRegSer.viewFollowUpReg(), HttpStatus.OK);
	}

	// update status of registration
	@PutMapping("status/{registrationId}")
	public void updateStatus(@PathVariable("registrationId") int registrationId) {

		registerSer.statusUpdate(registrationId);

	}

	// search by date
	@GetMapping("registers/{registrationDate}")
	public ResponseEntity<List<Registration>> searchByDate(
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("registrationDate") LocalDate registrationDate) {
		return new ResponseEntity<List<Registration>>(registerSer.showNewRegisters(registrationDate), HttpStatus.OK);
	}
	
	//login for coordinator
	
	@Autowired
	private ICoordinatorSer coSer;
	
	@GetMapping("login/{username}&{password}")
	public ResponseEntity<Coordinator> login(@PathVariable("username")String username,@PathVariable("password")String password){
		
		ResponseEntity<Coordinator> response = null;
		Coordinator coord = coSer.findByLoginCo(username, password);
		
		if(username == null && password == null) {
			
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response = new ResponseEntity<>(coord,HttpStatus.OK);
			
		}
		return response;
		
	}
}


