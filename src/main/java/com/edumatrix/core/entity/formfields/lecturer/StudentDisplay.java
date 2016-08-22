package com.edumatrix.core.entity.formfields.lecturer;

public class StudentDisplay {

	private String courseId;
	private String classId;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentDisplay [courseId=" + courseId + ", classId=" + classId + "]";
	}
	
}