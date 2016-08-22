package com.edumatrix.core.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edumatrix.core.dao.UserDAO;
import com.edumatrix.core.entity.User;
import com.edumatrix.core.service.InstituteService;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate dbMan;
	
	private InstituteService instituteService;
	
	private String sql = "";
	
	public User getUser(int userId) {
		
		try{
			sql = "SELECT * FROM global_useraccounts WHERE user_id=?";
			User user = dbMan.queryForObject(sql, new Object[] {userId}, new UserMapper());
			
			sql = "SELECT inst_id FROM global_useraccounts WHERE user_id=?";
			int instId = dbMan.queryForObject(sql, Integer.class, userId);
			
			user.setInstitute(instituteService.getInstituteNameById(instId));
				
			return user;
		}catch(Exception e){
			System.out.println("Couldn't assemble the User object");
			e.printStackTrace();
			return null;
		}
			
		
		
	}
	
	
	public int getUserAuthenticated(int instId, String username, String password){
		try{
			sql = "SELECT COUNT(*) FROM global_useraccounts WHERE inst_id=? AND username=? AND password=?";
			int userCount = dbMan.queryForObject(sql, Integer.class, instId, username, password);
			if(userCount != 1){
				return 0;
			}else{
				sql = "SELECT user_id FROM global_useraccounts WHERE inst_id=? AND username=? AND password=?";
				return (int)dbMan.queryForObject(sql, Integer.class, instId, username, password);
			}
		}catch(Exception e){
			System.out.println("Couldn't authenticate credentials");
			e.printStackTrace();
			return 0;
		}
	}

	
	
	private static final class UserMapper implements RowMapper<User> {
	
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setName(rs.getString("user_name"));
	        user.setUserId(rs.getInt("user_id"));
	        user.setUserName(rs.getString("username"));
	        user.setAuthLevel(rs.getString("auth_level"));
	        return user;
	    }
	}

}
