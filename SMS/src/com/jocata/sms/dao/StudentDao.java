package com.jocata.sms.dao;

import com.jocata.sms.entity.StudentEntity;

public interface StudentDao {
	public String createStu(StudentEntity stuEntity);
	public StudentEntity getStu(long stuId);
	public String updateStu(StudentEntity stuEntity);
	public String deleteStu(long stuId);
	public void getAllStu();

}
