package com.jocata.bms.service.impl;

import com.jocata.bms.bean.UserDetailsBean;
import com.jocata.bms.dao.LoginDao;
import com.jocata.bms.dao.impl.LoginDaoImpl;
import com.jocata.bms.entity.UserDetails;
import com.jocata.bms.service.LoginService;

public class LoginServiceImpl implements LoginService   {
	
	LoginDao dao = new LoginDaoImpl();
	
	public String signUp(UserDetailsBean ud ) {
		UserDetails u=new UserDetails();
		
		u.setFname(ud.getFname());
		u.setLname(ud.getLname());
		u.setEmail(ud.getEmail());
		u.setMobile(Long.parseLong(ud.getMobile()));
		u.setUserName(ud.getUserName());
		u.setPassword(ud.getPassword());
		
		dao.signUp(u);
		return "";
	}
	public String signIn(String uname,String pass) {
		dao.signIn(uname,pass);
		return "";
	}
	
	
	
}
