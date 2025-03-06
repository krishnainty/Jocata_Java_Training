package com.jocata.sms.dao.impl;

import java.util.List;

import com.jocata.sms.dao.AdminDao;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.persistence.*;

public class AdminDaoImpl implements AdminDao{
	EntityManager eManager=new EntityManagerImpl();

	@Override
	public String signUp(AdminEntity adEntity) {
		// TODO Auto-generated method stub
		eManager.save(AdminEntity.class, adEntity);
		System.out.println("Sign Up Successfull");
		
		
		return null;
	}

	@Override
	public String signIn(String uname, String pass) {
		// TODO Auto-generated method stub
		int f=0;
		List<Object> loginDetails = eManager.get(AdminEntity.class);
		for(Object object : loginDetails) {
			AdminEntity data = (AdminEntity) object;
			if(uname.equalsIgnoreCase(data.getUserName())
					&& pass.equalsIgnoreCase(data.getPassword())) {
				System.out.println("Login Successfull");
				f=1;
				break;
			}
			
		}
		if(f==0) {
			System.out.println("Invalid Credentials");
		}
		return null;
	}

	@Override
	public String getAdmin(String uname) {
		// TODO Auto-generated method stub
		int f=0;
		List<Object> loginDetails = eManager.get(AdminEntity.class);
		for(Object object : loginDetails) {
			AdminEntity data = (AdminEntity) object;
			if(uname.equalsIgnoreCase(data.getUserName())) {
				adminPrinting(data);
				f=1;
				break;
			}
			
		}
		if(f==0) {
			System.out.println("User Not Found");
		}
		
		return null;
	}
	public AdminEntity getAdmin2(String uname) {
		int f=0;
		List<Object> loginDetails = eManager.get(AdminEntity.class);
		for(Object object : loginDetails) {
			AdminEntity data = (AdminEntity) object;
			if(uname.equalsIgnoreCase(data.getUserName())) {
				return data;
				
			}
			
		}
		
		
		return null;
	}

	@Override
	public String updateAdmin(AdminEntity ad) {
		// TODO Auto-generated method stub
		eManager.update(AdminEntity.class, ad);
		return null;
	}

	@Override
	public String deleteAdmin(String uname) {
		// TODO Auto-generated method stub
		AdminEntity adEnt=getAdmin2(uname);
		eManager.delete(AdminEntity.class, uname);
		System.out.println("Data Successfully deleted");
		return null;
	}
	public void adminPrinting(AdminEntity adEn) {
		System.out.println("UserName: "+adEn.getUserName());
		System.out.println("Password: "+adEn.getPassword());
	}

}
