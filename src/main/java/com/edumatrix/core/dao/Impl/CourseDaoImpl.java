package com.edumatrix.core.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.edumatrix.core.dao.CourseDao;
import com.edumatrix.core.entity.Course;


public class CourseDaoImpl implements CourseDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrUpdate(Course course){
		
		if(course.getCrs_id() != null){
			String sql = "UPDATE course SET crs_name=?, "
									+ "date_started=?, "
									+ "duration=?, "
									+ "fee=? "
						+ " WHERE crs_id=?";
			
			jdbcTemplate.update(sql, 
					course.getName(), 
					course.getDate_started(),
					course.getDuration(), 
					course.getFee(), 
					course.getCrs_id()
					);
		}
		else{
			String sql = "INSERT INTO course(crs_id, crs_name, date_started, duration, fee) values(?,?,?,?,?)";
			jdbcTemplate.update(sql,
					course.getCrs_id(),
					course.getName(), 
					course.getDate_started(),
					course.getDuration(), 
					course.getFee()
					);
		}
		
	}
    
	@Override
    public void delete(int crs_id){
    	
    	String sql="DELETE FROM course WHERE crs_id=?";
    	jdbcTemplate.update(sql,crs_id);
    	
    }
     
	@Override
    public Course get(int crs_id){
    	
    	String sql="SELECT * FROM course WHERE crs_id=?";
    	return jdbcTemplate.query(sql, new ResultSetExtractor<Course>(){
    		
    		@Override
    		public Course extractData(ResultSet rs) throws SQLException, DataAccessException{
    			
    			if(rs.next()){
    				Course course = new Course();
    				course.setCrs_id(rs.getString("crs_id"));
        			course.setName(rs.getString("crs_name"));
        			course.setDate_started(rs.getString("date_started"));
        			course.setDuration(rs.getString("duration"));
        			course.setFee(rs.getString("fee"));
    				return course;
    			}
    			return null;
    		}	
    	});		  	
    }
     
    public List<Course> list(){
    	
    	String sql = "SELECT * FROM course";
    	
    	List<Course> courseList = jdbcTemplate.query(sql,
    			new RowMapper<Course>(){
    		
    		@Override
    		public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
    			
    			Course course = new Course();
    			course.setCrs_id(rs.getString("crs_id"));
    			course.setName(rs.getString("crs_name"));
    			course.setDate_started(rs.getString("date_started"));
    			course.setDuration(rs.getString("duration"));
    			course.setFee(rs.getString("fee"));
    			
    			return course;
    		}
    		
    	});
    	
    	return courseList;
    	
    }
	
}
