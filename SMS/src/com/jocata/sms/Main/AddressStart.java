package com.jocata.sms.Main;

import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.controller.AddressController;

public class AddressStart {
	public static void main(String args[]) {
		AddressController addCon=new AddressController();
		AddressBean addBean=new AddressBean();
		addBean.setArea("Banjara hills ");
		addBean.setCity("TPG");
		addBean.setPincode("12345");
		addBean.setState("AP");
		addBean.setAddressId(4722);
		
		//addCon.createAdd(addBean);
		//addCon.getAdd(3138);
		//addCon.updateAdd(addBean);
		//addCon.deleteAdd(4722);
		
		addCon.getAllAdd();
	}

}
