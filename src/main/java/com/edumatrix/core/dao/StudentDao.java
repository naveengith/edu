package com.edumatrix.core.dao;

import java.util.List;

import com.edumatrix.core.entity.Student;


public interface StudentDao {
	
public void saveOrUpdate(Student student);
    
    public void delete(int std_id);
     
    public Student get(int std_id);
     
    public List<Student> list();
	
}
