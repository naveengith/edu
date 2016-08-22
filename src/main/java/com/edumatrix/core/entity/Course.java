package com.edumatrix.core.entity;

public class Course {
	
	private String crs_id;
	private String name;
	private String date_started;
	private String duration;
	private String fee;
	
	public String getCrs_id() {
		return crs_id;
	}
	public void setCrs_id(String crs_id) {
		this.crs_id = crs_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_started() {
		return date_started;
	}
	public void setDate_started(String date_started) {
		this.date_started = date_started;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	
	
	
}
