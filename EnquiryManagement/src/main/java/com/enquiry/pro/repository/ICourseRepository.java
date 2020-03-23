package com.enquiry.pro.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.enquiry.pro.model.Course;

public interface ICourseRepository extends JpaRepositoryImplementation<Course, Integer>{

}
