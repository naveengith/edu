package com.edumatrix.core.entity.formfields.officer;

public class StudentSearchParams {
	
	private String courseId;
	private String studId;
	private String studName;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStudId() {
		return studId;
	}
	public void setStudId(String studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	@Override
	public String toString() {
		return "StudentSearchParams [courseId=" + courseId + ", studId=" + studId + ", studName=" + studName + "]";
	}
	

	
	

}
