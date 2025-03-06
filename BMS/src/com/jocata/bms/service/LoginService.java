package com.jocata.bms.service;

import com.jocata.bms.bean.UserDetailsBean;

public interface LoginService {
	public String signUp(UserDetailsBean ud ); 
	public String signIn(String uname,String pass);
		
	


}
