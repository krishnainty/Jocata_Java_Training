package com.jocata.sms.entity;

import java.io.Serializable;
import java.util.List;

public class StudentEntity implements Serializable {
	private long studentId;
	private String stuName;
	private String stuEmail;
	private String stuMobile;
	private String stuDob;
	private String stuGender;
	private AddressEntity stuAdd;
	private List<CourseEntity> stuCourses;
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuMobile() {
		return stuMobile;
	}
	public void setStuMobile(String stuMobile) {
		this.stuMobile = stuMobile;
	}
	public String getStuDob() {
		return stuDob;
	}
	public void setStuDob(String stuDob) {
		this.stuDob = stuDob;
	}
	public String getStuGender() {
		return stuGender;
	}
	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}
	public AddressEntity getStuAdd() {
		return stuAdd;
	}
	public void setStuAdd(AddressEntity stuAdd) {
		this.stuAdd = stuAdd;
	}
	public List<CourseEntity> getStuCourses() {
		return stuCourses;
	}
	public void setStuCourses(List<CourseEntity> stuCourses) {
		this.stuCourses = stuCourses;
	} 

}
