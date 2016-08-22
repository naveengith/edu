package com.edumatrix.core.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumatrix.core.dao.InstituteDAO;
import com.edumatrix.core.entity.Institute;
import com.edumatrix.core.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	private InstituteDAO instituteDAO;
	
	@Override
	public Institute getInstituteNameById(int inst_id) {
		
		return instituteDAO.getInstituteNameById(inst_id);
	}

	@Override
	public List<Institute> fetchAllInstitutes() {
		
		return instituteDAO.fetchAllInstitutes();
	}

	@Override
	public Integer countInstitutes(int inst_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInstitute(Institute institute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInstitute(Institute institute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInstitute(int inst_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Institute getInstitute(int inst_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Institute> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstituteSchemaById(int inst_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
