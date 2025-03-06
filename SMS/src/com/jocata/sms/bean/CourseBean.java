package com.jocata.sms.bean;

import java.io.Serializable;
import java.util.List;

import com.jocata.sms.entity.LecturerEntity;

public class CourseBean extends BaseBean implements Serializable {
	
	private String courseName;
	private String description;
	private String courseType;
	private String courseDuration;
	private List<LecturerBean> courseLecturers;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public List<LecturerBean> getCourseLecturers() {
		return courseLecturers;
	}
	public void setCourseLecturers(List<LecturerBean> courseLecturers) {
		this.courseLecturers = courseLecturers;
	}

}
