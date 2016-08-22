package com.edumatrix.core.dao;

import java.util.List;

import com.edumatrix.core.entity.Institute;

public interface InstituteDAO {

	public Institute getInstituteNameById(int inst_id);
	public List<Institute> fetchAllInstitutes();
}
