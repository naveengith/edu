package com.edumatrix.core.service;

import java.util.List;

import com.edumatrix.core.entity.Institute;

public interface InstituteService {
	
	public Institute getInstituteNameById(int inst_id);
	
	public List<Institute> fetchAllInstitutes();
	
	Integer countInstitutes(int inst_id);
		
	void addInstitute(Institute institute);
	 
	void updateInstitute(Institute institute);
   
    void deleteInstitute(int inst_id);
    
    Institute getInstitute(int inst_id);
    
    List<Institute> list();
    	
	String getInstituteSchemaById(int inst_id);

}
