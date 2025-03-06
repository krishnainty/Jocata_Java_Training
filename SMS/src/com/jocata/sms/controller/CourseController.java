package com.jocata.sms.controller;

import com.jocata.sms.bean.CourseBean;
import com.jocata.sms.service.*;
import com.jocata.sms.service.impl.CourseServiceImpl;

public class CourseController {
	CourseService courServ=new CourseServiceImpl();
	public String createCour(CourseBean courBean) {
		courServ.createCour(courBean);
		
		return "";
	}
	public CourseBean getCour(long courId) {
		courServ.getCour(courId);
		
		return null;
	}
	public String updateCour(CourseBean courBean) {
		courServ.updateCour(courBean);
		
		return "";
	}
	public String deleteCour(long courId) {
		courServ.deleteCour(courId);
		
		return "";
	}
	public void getAllCour() {
		courServ.getAllCour();
		
	}
	

}
