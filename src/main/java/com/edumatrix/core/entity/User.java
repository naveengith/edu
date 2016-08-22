package com.edumatrix.core.entity;

public class User {
	
	private int userId;
	private String userName;
	private String name;
	private String authLevel;
	private Institute institute;
	
	
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	

}
