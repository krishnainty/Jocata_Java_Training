package com.jocata.sms.service;

import com.jocata.sms.bean.StudentBean;

public interface StudentService {
	public String createStu(StudentBean stuBean);
	public StudentBean getStu(long stuId);
	public String updateStu(StudentBean stuBean);
	public String deleteStu(long stuId);
	public void getAllStu();

}
