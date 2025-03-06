package com.jocata.sms.dao.impl;

import java.util.List;
import java.util.Random;

import com.jocata.sms.dao.LecturerDao;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.EntityManagerImpl;

public class LecturerDaoImpl implements LecturerDao {
	EntityManager eManager=new EntityManagerImpl();

	@Override
	public String createLect(LecturerEntity lEntity) {
		// TODO Auto-generated method stub
		 
		eManager.save(LecturerEntity.class, lEntity);
		System.out.println("Data Successfully saved");
		
		
		return null;
	}

	@Override
	public String getLect(long lectId) {
		// TODO Auto-generated method stub
		
		int f=0;
		List<Object> lecDetails = eManager.get(LecturerEntity.class);
		for(Object object : lecDetails) {
			LecturerEntity data = (LecturerEntity) object;
			if(data.getLecturerId()==lectId) {
				lecPrint(data);
				f=1;
				break;
			}
			
		}
		if(f==0) {
			System.out.println("Invalid Credentials");
		}
		return null;
	}
	public LecturerEntity getLect2(long lectId) {
	
		List<Object> lecDetails = eManager.get(LecturerEntity.class);
		for(Object object : lecDetails) {
			LecturerEntity data = (LecturerEntity) object;
			if(data.getLecturerId()==lectId) {
				return data;
			}
			
		}
		
		return null;
	}

	@Override
	public String updateLect(LecturerEntity lEntity) {
		// TODO Auto-generated method stub
		System.out.println(lEntity.getLecturerId());
		eManager.update(LecturerEntity.class, lEntity);
		System.out.println("Data Successfully updated");
		return null;
	}

	@Override
	public String deleteLect(long lectId) {
		// TODO Auto-generated method stub
		LecturerEntity lEnt=getLect2(lectId);
		eManager.delete(LecturerEntity.class, lEnt);
		System.out.println("Data Successfully deleted");
		
		return null;
	}
	

	@Override
	public void getAllLect() {
		// TODO Auto-generated method stub
		
		List<Object> lecDetails = eManager.get(LecturerEntity.class);
		for(Object object : lecDetails) {
			LecturerEntity data = (LecturerEntity) object;
			lecPrint(data);			
			
		}
		if(lecDetails.isEmpty()) {
			System.out.println("No Data to Display");
		}
		
		
	}
	public void lecPrint(LecturerEntity lecEnt) {
		System.out.println("Lecturer Id: "+lecEnt.getLecturerId());
		System.out.println("Lecturer Name: "+lecEnt.getLecturerName());
		System.out.println("Lecturer Email: "+lecEnt.getLecturerEmail());
		System.out.println("Lecturer Phone: "+lecEnt.getLecturerPhone());
	}

}
