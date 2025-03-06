package com.jocata.sms.service.impl;

import java.util.Random;

import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.service.AddressService;
import com.jocata.sms.dao.impl.*;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.dao.*;

public class AddressServiceImpl implements AddressService {
	AddressDao addDao=new AddressDaoImpl();

	@Override
	public String createAdd(AddressBean addBean) {
		// TODO Auto-generated method stub
		AddressEntity addEnt=new AddressEntity();
		addEnt.setArea(addBean.getArea());
		addEnt.setCity(addBean.getCity());
		addEnt.setPincode(addBean.getPincode());
		addEnt.setState(addBean.getState());
		Random rand = new Random();
		 int rand_int = rand.nextInt(10000);
		 System.out.println("Your AddressId is "+rand_int);
		 addEnt.setAddressId(rand_int);
		 addDao.createAdd(addEnt);
		return null;
	}

	@Override
	public AddressBean getAdd(long addId) {
		// TODO Auto-generated method stub
		AddressEntity addEntity=addDao.getAdd(addId);
		if(addEntity==null)
			System.out.println("No address Found");
		else {
			addPrint(addEntity);
		}
		
		return null;
	}

	@Override
	public String updateAdd(AddressBean addBean) {
		// TODO Auto-generated method stub
		AddressEntity addEnt=new AddressEntity();
		addEnt.setArea(addBean.getArea());
		addEnt.setCity(addBean.getCity());
		addEnt.setPincode(addBean.getPincode());
		addEnt.setState(addBean.getState());
		addEnt.setAddressId(addBean.getAddressId());
		addDao.updateAdd(addEnt);
		
		
		return null;
	}

	@Override
	public String deleteAdd(long addId) {
		// TODO Auto-generated method stub
		addDao.deleteAdd(addId);
		return null;
	}

	@Override
	public void getAllAdd() {
		// TODO Auto-generated method stub
		addDao.getAllAdd();
		
	}
	public void addPrint(AddressEntity addEntity) {
		System.out.println("AddressId: "+addEntity.getAddressId());
		System.out.println("Area: "+addEntity.getArea());
		System.out.println("City: "+addEntity.getCity());
		System.out.println("State: "+addEntity.getState());
		System.out.println("PinCode: "+addEntity.getPincode());
	}

}
