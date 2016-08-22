package com.edumatrix.core.service;

import java.util.List;

import com.edumatrix.core.entity.Officer;

public interface OfficerService {
	
	Integer countOfficers(int user_id);
	
	void addOfficer(Officer officer);
    
	void updateOfficer(Officer officer);
	
    void deleteOfficer(int user_id);
     
    Officer getOfficerById(int user_id);
     
    List<Officer> fetchAllOfficers();
	
}