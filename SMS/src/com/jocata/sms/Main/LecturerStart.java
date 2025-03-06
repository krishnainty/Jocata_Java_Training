package com.jocata.sms.Main;

import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.controller.LecturerController;

public class LecturerStart {
	public static void main(String args[]) {
		LecturerController lc=new LecturerController();
		LecturerBean lBean=new LecturerBean();
		lBean.setLecturerId(1416);
		lBean.setLecturerName("mohan");
		lBean.setLecturerPhone("1234");
		lBean.setLecturerEmail("123@gmail");
		//lc.createLect(lBean);
		//lc.getLect(1416);
		//lc.updateLect(lBean);
		//lc.deleteLect(406);
		lc.getAllLect();
		
		
	}

}
