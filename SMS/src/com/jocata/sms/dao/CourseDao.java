package com.jocata.sms.dao;

import com.jocata.sms.entity.CourseEntity;

public interface CourseDao {
	public String createCour(CourseEntity courEntity);
	public CourseEntity getCour(long courId);
	public String updateCour(CourseEntity courEntity);
	public String deleteCour(long courId);
	public void getAllCour();

}
