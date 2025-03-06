package com.jocata.sms.service.impl;

import java.util.Random;

import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.service.LecturerService;
import com.jocata.sms.dao.*;
import com.jocata.sms.dao.impl.LecturerDaoImpl;
import com.jocata.sms.entity.LecturerEntity;

public class LecturerServiceImpl implements LecturerService{
	LecturerDao lDao=new LecturerDaoImpl();
	

	@Override
	public String createLect(LecturerBean lBean) {
		// TODO Auto-generated method stub
		LecturerEntity lEntity=new LecturerEntity();
		lEntity.setLecturerEmail(lBean.getLecturerEmail());
		lEntity.setLecturerName(lBean.getLecturerName());
		lEntity.setLecturerPhone(lBean.getLecturerPhone());
		Random rand = new Random();
		 int rand_int = rand.nextInt(10000);
		 System.out.println("Your LecturerId is "+rand_int);
		 lEntity.setLecturerId(rand_int);
		lDao.createLect(lEntity);
		return null;
	}

	@Override
	public String getLect(long lectId) {
		// TODO Auto-generated method stub
		lDao.getLect(lectId);
		return null;
	}

	@Override
	public String updateLect(LecturerBean lBean) {
		// TODO Auto-generated method stub
		LecturerEntity lEntity=new LecturerEntity();
		lEntity.setLecturerId(lBean.getLecturerId());
		lEntity.setLecturerEmail(lBean.getLecturerEmail());
		lEntity.setLecturerName(lBean.getLecturerName());
		lEntity.setLecturerPhone(lBean.getLecturerPhone());
		lDao.updateLect(lEntity);
		
		return null;
	}

	@Override
	public String deleteLect(long lectId) {
		// TODO Auto-generated method stu
		lDao.deleteLect(lectId);
		return null;
	}

	@Override
	public void getAllLect() {
		// TODO Auto-generated method stub
		lDao.getAllLect();
		
	}

}
