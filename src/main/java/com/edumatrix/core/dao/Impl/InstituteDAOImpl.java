package com.edumatrix.core.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edumatrix.core.dao.InstituteDAO;
import com.edumatrix.core.entity.Institute;


@Repository
public class InstituteDAOImpl implements InstituteDAO{

	@Autowired
	private JdbcTemplate dbMan;
	
	
	@Override
	public Institute getInstituteNameById(int inst_id) {
		
		String sql = "SELECT * FROM global_institutes WHERE inst_id=?";
		return dbMan.queryForObject(sql, new Object[] {inst_id}, new InstituteMapper());
		
	}
	
	@Override
	public List<Institute> fetchAllInstitutes() {
		
		return dbMan.query("SELECT * FROM global_institutes", new InstituteMapper());
	}
	
	private static final class InstituteMapper implements RowMapper<Institute> {
		
	    public Institute mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Institute institute = new Institute();
	        institute.setInst_id(rs.getInt("inst_id"));
	        institute.setInst_name(rs.getString("inst_name"));
	        institute.setInst_city(rs.getString("inst_city"));
	        institute.setInst_schema(rs.getString("schema_name"));
	        return institute;
	    }
	}

	

}
