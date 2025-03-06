package com.jocata.sms.entity;

import java.io.Serializable;

public class LecturerEntity implements Serializable{
	private long lecturerId;
	private String lecturerName;
	private String lecturerPhone;
	private String lecturerEmail;
	public long getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(long lecturerId) {
		this.lecturerId = lecturerId;
	}
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	public String getLecturerPhone() {
		return lecturerPhone;
	}
	public void setLecturerPhone(String lecturerPhone) {
		this.lecturerPhone = lecturerPhone;
	}
	public String getLecturerEmail() {
		return lecturerEmail;
	}
	public void setLecturerEmail(String lecturerEmail) {
		this.lecturerEmail = lecturerEmail;
	}

}
