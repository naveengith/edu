package com.edumatrix.core.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.edumatrix.core.dao.StudentDao;
import com.edumatrix.core.entity.Student;


public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(Student student){
		
		if(student.getStd_id() != null){
			String sql = "UPDATE reg_user SET email=?,"
											+ "address=?,"
											+ "tp_phone=?, "
											+ "salary=?, "
											+ "username=?, "
											+ "password=? "
						+ "WHERE reguser_id=? ";
			
			jdbcTemplate.update(sql, student.getEmail(), student.getAddress(),
									student.getTp_no(), student);
		}
		else{
			String sql = "INSERT INTO student(name,email,address) values(?,?,?,?)";
			jdbcTemplate.update(sql,student.getName(),student.getEmail(),
								student.getAddress());
		}
		
	}

	@Override
	public void delete(int std_id) {
		
		String sql="DELETE FROM student WHERE std_id=?";
    	jdbcTemplate.update(sql,std_id);
		
	}

	@Override
	public Student get(int std_id) {
		String sql="SELECT * FROM student WHERE std_id=?";
    	return jdbcTemplate.query(sql, new ResultSetExtractor<Student>(){
    		
    		@Override
    		public Student extractData(ResultSet rs) throws SQLException, DataAccessException{
    			
    			if(rs.next()){
    				Student student = new Student();
    				student.setStd_id(rs.getString("std_id"));
    				student.setName(rs.getString("name"));
    				student.setEmail(rs.getString("email"));
    				student.setAddress(rs.getString("address"));
    				student.setTp_no(rs.getString("tp_no"));
    				student.setUsername("username");
	    			student.setPassword("password");
    				
    				return student;
    			}
    			return null;
    		}	
    	});		  	
		
	}

	@Override
	public List<Student> list() {
			String sql = "SELECT * FROM student";
	    	
	    	List<Student> studentList = jdbcTemplate.query(sql,
	    			new RowMapper<Student>(){
	    		
	    		@Override
	    		public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
	    			
	    			Student student = new Student();
	    			student.setStd_id(rs.getString("std_id"));
	    			student.setName(rs.getString("name"));
	    			student.setEmail(rs.getString("email"));
	    			student.setAddress(rs.getString("address"));
	    			student.setTp_no(rs.getString("tp_no"));
	    			student.setUsername("username");
	    			student.setPassword("password");
	    			
	    			return student;
	    		}
	    		
	    	});
	    	
	    	return studentList;
		
	}
	
	
}
