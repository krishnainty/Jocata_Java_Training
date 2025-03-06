package com.jocata.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jocata.sms.bean.CourseBean;
import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.entity.*;
import com.jocata.sms.service.CourseService;
import com.jocata.sms.dao.*;
import com.jocata.sms.dao.impl.CourseDaoImpl;


public class CourseServiceImpl implements CourseService {
	CourseDao courDao=new CourseDaoImpl();
	@Override
	public String createCour(CourseBean courBean) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		 int rand_int1 = rand.nextInt(10000);
		 System.out.println("Your Course Id is: "+rand_int1);
		 
		CourseEntity courEnt=new CourseEntity();
		courEnt.setCourseId(rand_int1);
		courEnt.setCourseDuration(courBean.getCourseDuration());
		courEnt.setCourseName(courBean.getCourseName());
		courEnt.setCourseType(courBean.getCourseType());
//		courEnt.setCourseLecturers(courBean.getCourseLecturers());
		List<LecturerEntity>lEntList=new ArrayList<>();
		for(LecturerBean lBean:courBean.getCourseLecturers()) {
			
			 int rand_int = rand.nextInt(10000);
			 System.out.println("Your LecturerId is "+rand_int);
			 
			LecturerEntity lEntity=new LecturerEntity();
			lEntity.setLecturerId(rand_int);
			lEntity.setLecturerEmail(lBean.getLecturerEmail());
			lEntity.setLecturerName(lBean.getLecturerName());
			lEntity.setLecturerPhone(lBean.getLecturerPhone());
			lEntList.add(lEntity);
			
		}
		courEnt.setCourseLecturers(lEntList);
		courEnt.setDescription(courBean.getDescription());
		
		courDao.createCour(courEnt);
		
		
		return null;
	}

	@Override
	public CourseBean getCour(long courId) {
		// TODO Auto-generated method stub
		
		CourseEntity cEnt=courDao.getCour(courId);
		if(cEnt==null)
			System.out.println("No Course Found");
		else
			courPrint(cEnt);
		return null;
	}

	@Override
	public String updateCour(CourseBean courBean) {
		// TODO Auto-generated method stub
		
		CourseEntity courEnt=new CourseEntity();
		courEnt.setCourseId(courBean.getCourseId());
		courEnt.setCourseDuration(courBean.getCourseDuration());
		courEnt.setCourseName(courBean.getCourseName());
		courEnt.setCourseType(courBean.getCourseType());
//		courEnt.setCourseLecturers(courBean.getCourseLecturers());
		List<LecturerEntity>lEntList=new ArrayList<>();
		for(LecturerBean lBean:courBean.getCourseLecturers()) {
			
			 
			 
			LecturerEntity lEntity=new LecturerEntity();
			lEntity.setLecturerId(lBean.getLecturerId());
			lEntity.setLecturerEmail(lBean.getLecturerEmail());
			lEntity.setLecturerName(lBean.getLecturerName());
			lEntity.setLecturerPhone(lBean.getLecturerPhone());
			lEntList.add(lEntity);
			
		}
		courEnt.setCourseLecturers(lEntList);
		courEnt.setDescription(courBean.getDescription());
		
		
		courDao.updateCour(courEnt);
		return null;
	}

	@Override
	public String deleteCour(long courId) {
		// TODO Auto-generated method stub
		courDao.deleteCour(courId);
		return null;
	}

	@Override
	public void getAllCour() {
		// TODO Auto-generated method stub
		courDao.getAllCour();
		
	}
	public void courPrint(CourseEntity cEntity) {
		System.out.println("Course Id: "+cEntity.getCourseId());
		System.out.println("Course Name: "+cEntity.getCourseName());
		System.out.println("Course Description: "+cEntity.getDescription());
		System.out.println("Course Duration: "+cEntity.getCourseDuration());
		System.out.println("Course Type: "+cEntity.getCourseType());
		System.out.println("Course Lecturers are: ");
		for(LecturerEntity lecEnt:cEntity.getCourseLecturers()) {
			System.out.println("Lecturer Id: "+lecEnt.getLecturerId());
			System.out.println("Lecturer Name: "+lecEnt.getLecturerName());
			System.out.println("Lecturer Email: "+lecEnt.getLecturerEmail());
			System.out.println("Lecturer Phone: "+lecEnt.getLecturerPhone());
		}
	}
	

}
