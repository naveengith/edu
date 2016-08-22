package com.edumatrix.core.dao;

import java.util.List;

import com.edumatrix.core.entity.Officer;



public interface OfficerDao {
	
public void saveOrUpdate(Officer officer);
    
    public void delete(int ofcr_id);
     
    public Officer get(int ofcr_id);
     
    public List<Officer> list();
	
}
