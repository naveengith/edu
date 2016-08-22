package com.edumatrix.core.entity;

public class Student {
	
	private String std_id;
	private String name;
	private String address;
	private String tp_no;
	private String email;
	private String school;
	private String bday;
	private String username;
	private String password;
	
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTp_no() {
		return tp_no;
	}
	public void setTp_no(String tp_no) {
		this.tp_no = tp_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", name=" + name + ", address=" + address + ", tp_no=" + tp_no + ", email="
				+ email + ", school=" + school + ", bday=" + bday + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
