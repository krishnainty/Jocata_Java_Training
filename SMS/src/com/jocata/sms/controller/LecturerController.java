package com.jocata.sms.controller;
import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.service.*;
import com.jocata.sms.service.impl.LecturerServiceImpl;

public class LecturerController {
	LecturerService lServ=new LecturerServiceImpl();
	public String createLect(LecturerBean lBean) {
		lServ.createLect(lBean);
		
		
		
		return "";
		
	}
	public String getLect(long lectId) {
		lServ.getLect(lectId);
		return "";
	}
	public String updateLect(LecturerBean lBean) {
		lServ.updateLect(lBean);
		
		return "";
	}
	public String deleteLect(long lectId) {
		lServ.deleteLect(lectId);
		
		return "";
	}
	public void getAllLect() {
		lServ.getAllLect();
	}

}
