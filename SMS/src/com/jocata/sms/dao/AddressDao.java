package com.jocata.sms.dao;

import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.entity.AddressEntity;

public interface AddressDao {
	public String createAdd(AddressEntity addEnt);
	public AddressEntity getAdd(long addId);
	public String updateAdd(AddressEntity addEnt);
	public String deleteAdd(long addId);
	public void getAllAdd();
}
