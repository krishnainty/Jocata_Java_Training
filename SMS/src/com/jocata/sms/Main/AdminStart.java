package com.jocata.sms.Main;

import com.jocata.sms.bean.AdminBean;
import com.jocata.sms.controller.AdminController;

public class AdminStart {
	public static void main(String args[]) {
		AdminBean adBean=new AdminBean();
		adBean.setUserName("admi");
		adBean.setPassword("123");
		AdminController adCon=new AdminController();
		//adCon.signUp(adBean);
		//adCon.signIn("admin1", "1234");
		//adCon.getAdmin("admi");
		//adCon.updateAdmin(adBean);
		//adCon.deleteAdmin("admi");
	}

}
