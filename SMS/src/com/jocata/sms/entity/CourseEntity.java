package com.jocata.sms.entity;

import java.io.Serializable;
import java.util.List;

public class CourseEntity implements Serializable{
	private long courseId;
	private String courseName;
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
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
	public List<LecturerEntity> getCourseLecturers() {
		return courseLecturers;
	}
	public void setCourseLecturers(List<LecturerEntity> courseLecturers) {
		this.courseLecturers = courseLecturers;
	}
	private String description;
	private String courseType;
	private String courseDuration;
	private List<LecturerEntity> courseLecturers;

}
