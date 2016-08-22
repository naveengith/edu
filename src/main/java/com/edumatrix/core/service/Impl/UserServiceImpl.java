package com.edumatrix.core.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumatrix.core.dao.UserDAO;
import com.edumatrix.core.entity.User;
import com.edumatrix.core.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public int getUserAuthenticated(int instId, String username, String password) {
		
		return userDAO.getUserAuthenticated(instId, username, password);
	}

	@Override
	public User getUser(int userId) {
		
		return userDAO.getUser(userId);
	}

}
