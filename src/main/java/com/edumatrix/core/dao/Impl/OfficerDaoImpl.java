package com.edumatrix.core.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.edumatrix.core.dao.OfficerDao;
import com.edumatrix.core.entity.Officer;


public class OfficerDaoImpl implements OfficerDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(Officer officer){
		
		if(officer.getOfcr_id() != null){
			String sql = "UPDATE reg_user SET email=?,"
											+ "address=?,"
											+ "tp_no=?, "
											+ "salary=?, "
											+ "username=?, "
											+ "password=? "
						+ "WHERE reguser_id=? ";
			
			jdbcTemplate.update(sql, 
						officer.getEmail(), 
						officer.getAddress(),
						officer.getTp_no(), 
						officer.getSalary(),
						officer.getUsername(), 
						officer.getPassword(),
						officer.getReguser_id()
					);
		}
		else{
			String sql = "INSERT INTO reg_user(reguser_id, "
											+ "reguser_name, "
											+ "address, "
											+ "email, "
											+ "tp_no, "
											+ "gender,"
											+ "date_joined, "
											+ "salary, "
											+ "user_type, "
											+ "username, "
											+ "password) "
								+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			
			jdbcTemplate.update(sql,
						officer.getReguser_id(),
						officer.getName(),
						officer.getAddress(),
						officer.getEmail(),
						officer.getTp_no(),
						officer.getGender(),
						officer.getDate_joined(),
						officer.getSalary(),
						officer.getUser_type(),
						officer.getUsername(),
						officer.getPassword()
					);
		}
		
	}

	@Override
	public void delete(int ofcr_id) {
		
		String sql="DELETE FROM officer WHERE ofcr_id=?";                    //must change the sql here...
    	jdbcTemplate.update(sql,ofcr_id);
		
	}

	@Override
	public Officer get(int ofcr_id) {
		String sql="SELECT * FROM officer WHERE ofcr_id=?";                   //must change the sql here...a JOIN comes
    	return jdbcTemplate.query(sql, new ResultSetExtractor<Officer>(){
    		
    		@Override
    		public Officer extractData(ResultSet rs) throws SQLException, DataAccessException{
    			
    			if(rs.next()){
    				Officer officer = new Officer();
	    			officer.setOfcr_id(rs.getString("ofcr_id"));
	    			officer.setReguser_id(rs.getString("reguser_id"));
	    			officer.setName(rs.getString("reguser_name"));
	    			officer.setAddress(rs.getString("address"));
	    			officer.setEmail(rs.getString("email"));
	    			officer.setTp_no(rs.getString("tp_no"));
	    			officer.setGender(rs.getString("gender"));
	    			officer.setDate_joined(rs.getString("date_joined"));
	    			officer.setSalary(rs.getString("salary"));
    				
    				return officer;
    			}
    			return null;
    		}	
    	});		  	
		
	}

	@Override
	public List<Officer> list() {
			String sql = "SELECT * FROM officer"; //must change the sql here...a JOIN comes
	    	
	    	List<Officer> officerList = jdbcTemplate.query(sql,
	    			new RowMapper<Officer>(){
	    		
	    		@Override
	    		public Officer mapRow(ResultSet rs, int rowNum) throws SQLException{
	    			
	    			Officer officer = new Officer();
	    			officer.setOfcr_id(rs.getString("ofcr_id"));
	    			officer.setReguser_id(rs.getString("reguser_id"));
	    			officer.setName(rs.getString("reguser_name"));
	    			officer.setAddress(rs.getString("address"));
	    			officer.setEmail(rs.getString("email"));
	    			officer.setTp_no(rs.getString("tp_no"));
	    			officer.setGender(rs.getString("gender"));
	    			officer.setDate_joined(rs.getString("date_joined"));
	    			officer.setSalary(rs.getString("salary"));
	    			
	    			/*officer.setUsername("username");
	    			officer.setPassword("password");*/
	    			
	    			return officer;
	    		}
	    		
	    	});
	    	
	    	return officerList;
		
	}
	
}
