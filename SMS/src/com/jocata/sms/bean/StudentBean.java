package com.jocata.sms.bean;

import java.util.List;

import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.bean.CourseBean;

public class StudentBean extends BaseBean{
	private String stuName;
	private String stuEmail;
	private String stuMobile;
	private String stuDob;
	private String stuGender;
	private AddressBean stuAdd;
	private List<CourseBean> stuCourses;
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
	public AddressBean getStuAdd() {
		return stuAdd;
	}
	public void setStuAdd(AddressBean stuAdd) {
		this.stuAdd = stuAdd;
	}
	public List<CourseBean> getStuCourses() {
		return stuCourses;
	}
	public void setStuCourses(List<CourseBean> stuCourses) {
		this.stuCourses = stuCourses;
	}

	

}
