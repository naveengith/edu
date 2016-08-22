package com.edumatrix.core.service;

import java.util.List;

import com.edumatrix.core.entity.Course;

public interface CourseService {
	
	void saveOrUpdate(Course course);
    
    void delete(int crs_id);
    
    Course get(int crs_id);
    
    List<Course> list();
	
	
}