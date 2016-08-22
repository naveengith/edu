package com.edumatrix.core.service;

import com.edumatrix.core.entity.User;

public interface UserService {

	public int getUserAuthenticated(int instId, String username, String password);
	public User getUser(int userId);
	
}
