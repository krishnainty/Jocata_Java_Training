package com.jocata.sms.controller;

import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.service.*;
import com.jocata.sms.service.impl.AddressServiceImpl;

public class AddressController {
	AddressService addServ=new AddressServiceImpl();
	
	
	public String createAdd(AddressBean addBean) {
		addServ.createAdd(addBean);
		
		return "";
	}
	public AddressBean getAdd(long addId) {
		addServ.getAdd(addId);
		
		return null;
	}
	public String updateAdd(AddressBean addBean) {
		addServ.updateAdd(addBean);
		
		return "";
	}
	public String deleteAdd(long addId) {
		addServ.deleteAdd(addId);
		
		return "";
	}
	public void getAllAdd() {
		addServ.getAllAdd();
		
	}

}
