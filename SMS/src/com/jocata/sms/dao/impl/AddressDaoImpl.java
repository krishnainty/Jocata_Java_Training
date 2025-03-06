package com.jocata.sms.dao.impl;

import java.util.List;


import com.jocata.sms.bean.AddressBean;
import com.jocata.sms.dao.AddressDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.EntityManagerImpl;

public class AddressDaoImpl implements AddressDao{

	EntityManager eManager=new EntityManagerImpl();
	@Override
	public String createAdd(AddressEntity addEnt) {
		// TODO Auto-generated method stub
		eManager.save(AddressEntity.class, addEnt);
		System.out.println("Data Successfully saved");
		
		
		return null;
	}

	@Override
	public AddressEntity getAdd(long addId) {
		// TODO Auto-generated method stub
		
		List<Object> addDetails = eManager.get(AddressEntity.class);
		for(Object object : addDetails) {
			AddressEntity data = (AddressEntity) object;
			if(data.getAddressId()==addId) {
				return data;
			}
			
		}
		
		return null;
		
	}

	@Override
	public String updateAdd(AddressEntity addEnt) {
		// TODO Auto-generated method stub
		eManager.update(AddressEntity.class, addEnt);
		System.out.println("Data Successfully updated");
		return null;
	}

	@Override
	public String deleteAdd(long addId) {
		// TODO Auto-generated method stub
		AddressEntity addEntity=getAdd(addId);
		eManager.delete(AddressEntity.class, addEntity);
		System.out.println("Data Successfully deleted");
		return null;
	}

	@Override
	public void getAllAdd() {
		// TODO Auto-generated method stub
		
		List<Object> addDetails = eManager.get(AddressEntity.class);
		for(Object object : addDetails) {
			AddressEntity data = (AddressEntity) object;
			addPrint(data);			
			
		}
		if(addDetails.isEmpty()) {
			System.out.println("No Data to Display");
		}
		
	}
	public void addPrint(AddressEntity addEntity) {
		System.out.println("AddressId: "+addEntity.getAddressId());
		System.out.println("Area: "+addEntity.getArea());
		System.out.println("City: "+addEntity.getCity());
		System.out.println("State: "+addEntity.getState());
		System.out.println("PinCode: "+addEntity.getPincode());
		System.out.println("*********************");
	}

}
