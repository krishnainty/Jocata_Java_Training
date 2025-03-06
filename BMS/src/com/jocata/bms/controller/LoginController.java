package com.jocata.bms.controller;

import com.jocata.bms.bean.UserDetailsBean;
import com.jocata.bms.service.*;
import com.jocata.bms.service.impl.LoginServiceImpl;
public class LoginController {
	LoginService service=new LoginServiceImpl();
	public String signUp(UserDetailsBean ud ) {
		service.signUp(ud);
		return "";
	}
	public String signIn(String uname,String pass) {
		service.signIn(uname, pass);
		 return "";
	}
}
