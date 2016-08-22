package com.edumatrix.core.service;

import java.util.List;

import com.edumatrix.core.entity.Manager;

public interface ManagerService {
	
	Integer countManagers(int user_id);
	
	void addManager(Manager manager);
	
	void updateManager(Manager manager);
    
    void deleteManager(int user_id);
    
    public Manager getManagerById(int user_id);
    
    public List<Manager> fetchAllManagers();
	
	
}