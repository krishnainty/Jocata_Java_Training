package com.jocata.sms.service;

import com.jocata.sms.bean.AddressBean;

public interface AddressService {
	public String createAdd(AddressBean addBean);
	public AddressBean getAdd(long addId);
	public String updateAdd(AddressBean addBean);
	public String deleteAdd(long addId);
	public void getAllAdd();

}
