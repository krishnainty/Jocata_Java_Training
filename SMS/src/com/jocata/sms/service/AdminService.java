package com.jocata.sms.service;

import com.jocata.sms.bean.AdminBean;

public interface AdminService {
	public String signUp(AdminBean adBean);
	public String signIn(String uname,String pass);
	public String getAdmin(String uname);
	public String updateAdmin(AdminBean ad);
	public String deleteAdmin(String uname);

}
