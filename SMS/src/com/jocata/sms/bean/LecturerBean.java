package com.jocata.sms.bean;

import java.io.Serializable;

public class LecturerBean extends BaseBean implements Serializable{
	private String lecturerName;
	private String lecturerPhone;
	private String lecturerEmail;
	public String getLecturerName()  {
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
