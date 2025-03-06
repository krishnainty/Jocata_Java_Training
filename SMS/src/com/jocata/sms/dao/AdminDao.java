package com.jocata.sms.dao;

import com.jocata.sms.entity.AdminEntity;

public interface AdminDao {
	public String signUp(AdminEntity adEntity);
	public String signIn(String uname,String pass);
	public String getAdmin(String uname);
	public String updateAdmin(AdminEntity ad);
	
	public String deleteAdmin(String uname);

}
