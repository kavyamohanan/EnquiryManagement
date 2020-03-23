package com.enquiry.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.pro.model.Course;
import com.enquiry.pro.repository.ICourseRepository;

@Service
public class CourseService implements ICourseService{

	//instance for Course Repository
	@Autowired
	private ICourseRepository courseRepo;
	
	
	//method to list all courses
	@Override
	public List<Course> courseList() {
	
		return courseRepo.findAll();
	}

}
