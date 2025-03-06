package com.jocata.sms.controller;

import com.jocata.sms.bean.AdminBean;
import com.jocata.sms.service.*;
import com.jocata.sms.service.impl.AdminServiceImpl;

public class AdminController {
	AdminService adServ=new AdminServiceImpl();
	public String signUp(AdminBean adBean) {
		adServ.signUp(adBean);
		
		return "";
	}
	public String signIn(String uname,String pass) { 
		adServ.signIn(uname, pass);
		
		return "";
	}
	
	public String getAdmin(String uname) {
		adServ.getAdmin(uname);
		
		return "";
	}
	public String updateAdmin(AdminBean ad) {
		adServ.updateAdmin(ad);
		
		return "";
	}
	public String deleteAdmin(String uname) {
		adServ.deleteAdmin(uname);
		return "";
	}
	

}
