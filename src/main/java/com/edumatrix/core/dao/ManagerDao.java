package com.edumatrix.core.dao;

import java.util.List;

import com.edumatrix.core.entity.Manager;



public interface ManagerDao {
	
	public void saveOrUpdate(Manager manager);
    
    public void delete(int mgr_id);
     
    public Manager get(int mgr_id);
     
    public List<Manager> list();
	
}
