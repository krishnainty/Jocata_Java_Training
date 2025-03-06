package com.jocata.sms.dao.impl;

import java.util.List;

import com.jocata.sms.dao.CourseDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CourseEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.EntityManagerImpl;

public class CourseDaoImpl implements CourseDao{
	
	EntityManager eManager=new EntityManagerImpl();
	@Override
	public String createCour(CourseEntity courEntity) {
		// TODO Auto-generated method stub
		eManager.save(CourseEntity.class, courEntity);
		System.out.println("Data Successfully saved");
		
		
		return null;
	}

	@Override
	public CourseEntity getCour(long courId) {
		// TODO Auto-generated method stub
		List<Object> courDetails = eManager.get(CourseEntity.class);
		for(Object object : courDetails) {
			CourseEntity data = (CourseEntity) object;
			if(data.getCourseId()==courId) {
				return data;
			}
			
		}
		
		return null;
		
		
	}

	@Override
	public String updateCour(CourseEntity courEntity) {
		// TODO Auto-generated method stub
		eManager.update(CourseEntity.class, courEntity);
		System.out.println("Data Successfully updated");
		return null;
	}

	@Override
	public String deleteCour(long courId) {
		// TODO Auto-generated method stub
		CourseEntity courEnt=getCour(courId);
		eManager.delete(CourseEntity.class, courEnt);
		System.out.println("Data Successfully deleted");
		
		return null;
	}

	@Override
	public void getAllCour() {
		// TODO Auto-generated method stub
		List<Object> courDetails = eManager.get(CourseEntity.class);
		
		for(Object object : courDetails) {
			CourseEntity data = (CourseEntity) object;
			courPrint(data);			
			
		}
		if(courDetails.isEmpty()) {
			System.out.println("No Data to Display");
		}
		
		
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
		System.out.println();
	}
	

}
