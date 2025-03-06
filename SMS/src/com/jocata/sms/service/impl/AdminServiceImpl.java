package com.jocata.sms.service.impl;

import com.jocata.sms.bean.AdminBean;
import com.jocata.sms.service.AdminService;
import com.jocata.sms.dao.*;
import com.jocata.sms.dao.impl.AdminDaoImpl;
import com.jocata.sms.entity.AdminEntity;

public class AdminServiceImpl implements AdminService{
	AdminDao adDao=new AdminDaoImpl();

	@Override
	public String signUp(AdminBean adBean) {
		
		// TODO Auto-generated method stub
		AdminEntity adEntity=new AdminEntity();
		adEntity.setUserName(adBean.getUserName());
		adEntity.setPassword(adBean.getPassword());
		adDao.signUp(adEntity);
		
		return null;
	}

	@Override
	public String signIn(String uname, String pass) {
		// TODO Auto-generated method stub
		adDao.signIn(uname, pass);
		return null;
	}

	@Override
	public String getAdmin(String uname) {
		// TODO Auto-generated method stub
		adDao.getAdmin(uname);
		return null;
	}

	@Override
	public String updateAdmin(AdminBean ad) {
		// TODO Auto-generated method stub
		AdminEntity adEntity=new AdminEntity();
		adEntity.setUserName(ad.getUserName());
		adEntity.setPassword(ad.getPassword());
		adDao.updateAdmin(adEntity);
		System.out.println("Data Successfully updated");
		
		
		return null;
	}

	@Override
	public String deleteAdmin(String uname) {
		// TODO Auto-generated method stub
		adDao.deleteAdmin(uname);
		return null;
	}
	

}
