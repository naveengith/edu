package com.edumatrix.core.dao;

import com.edumatrix.core.entity.User;

public interface UserDAO {

	public int getUserAuthenticated(int instId, String username, String password);
	
	public User getUser(int userId);

}
