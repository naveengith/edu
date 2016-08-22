package com.edumatrix.core.dao;

import java.util.List;

import com.edumatrix.core.entity.Course;



public interface CourseDao {
	
	public void saveOrUpdate(Course course);
    
    public void delete(int crs_id);
     
    public Course get(int crs_id);
     
    public List<Course> list();
	
}
