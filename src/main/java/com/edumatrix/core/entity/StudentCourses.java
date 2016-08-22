package com.edumatrix.core.entity;

public class StudentCourses {
	
	private String name;
	private String course;
	private int stud_ID;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getStud_ID() {
		return stud_ID;
	}
	public void setStud_ID(int stud_ID) {
		this.stud_ID = stud_ID;
	}
	
	@Override
	public String toString() {
		return "StudentCourses [name=" + name + ", course=" + course + ", stud_ID=" + stud_ID + "]";
	}
	
	

}
