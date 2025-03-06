package com.jocata.sms.service;

import com.jocata.sms.bean.CourseBean;

public interface CourseService {
	public String createCour(CourseBean courBean);
	public CourseBean getCour(long courId);
	public String updateCour(CourseBean courBean);
	public String deleteCour(long courId);
	public void getAllCour();

}
