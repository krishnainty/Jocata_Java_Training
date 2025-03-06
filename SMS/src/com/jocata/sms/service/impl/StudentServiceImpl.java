package com.jocata.sms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jocata.sms.bean.CourseBean;
import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.bean.StudentBean;
import com.jocata.sms.service.StudentService;
import com.jocata.sms.dao.*;
import com.jocata.sms.dao.impl.StudentDaoImpl;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.*;

public class StudentServiceImpl implements StudentService,Serializable{
	StudentDao stuDao=new StudentDaoImpl();
	@Override
	public String createStu(StudentBean stuBean) {
		
		// TODO Auto-generated method stub
		Random rand = new Random();
		 int rand_int = rand.nextInt(10000);
		 
		StudentEntity stuEnt=new StudentEntity();
		stuEnt.setStudentId(rand_int);
		System.out.println("Your StudentId is:"+rand_int);
		
		stuEnt.setStuName(stuBean.getStuName());
		stuEnt.setStuEmail(stuBean.getStuEmail());
		stuEnt.setStuMobile(stuBean.getStuMobile());
		stuEnt.setStuDob(stuBean.getStuDob());
		stuEnt.setStuGender(stuBean.getStuGender());
		
		if (stuBean.getStuAdd() != null) {
			int rand_int1 = rand.nextInt(10000);
			
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressId(rand_int1);
            addressEntity.setArea(stuBean.getStuAdd().getArea());
            addressEntity.setCity(stuBean.getStuAdd().getCity());
            addressEntity.setState(stuBean.getStuAdd().getState());
            addressEntity.setPincode(stuBean.getStuAdd().getPincode());
            stuEnt.setStuAdd(addressEntity);
        }
		
		 if (stuBean.getStuCourses() != null) {
			 
	            List<CourseEntity> courseEntities = new ArrayList<>();
	            for (CourseBean courseBean : stuBean.getStuCourses()) {
	            	int rand_int2 = rand.nextInt(10000);
	                CourseEntity courseEntity = new CourseEntity();
	                courseEntity.setCourseId(rand_int2);
	                courseEntity.setCourseName(courseBean.getCourseName());
	                courseEntity.setDescription(courseBean.getDescription());
	                courseEntity.setCourseType(courseBean.getCourseType());
	                courseEntity.setCourseDuration(courseBean.getCourseDuration());

	                
	                if (courseBean.getCourseLecturers() != null) {
	                	
	                    List<LecturerEntity> lecturerEntities = new ArrayList<>();
	                    for (LecturerBean lecturerBean : courseBean.getCourseLecturers()) {
	                    	int rand_int3 = rand.nextInt(10000);
	                        LecturerEntity lecturerEntity = new LecturerEntity();
	                        lecturerEntity.setLecturerId(rand_int3);
	                        lecturerEntity.setLecturerName(lecturerBean.getLecturerName());
	                        lecturerEntity.setLecturerPhone(lecturerBean.getLecturerPhone());
	                        lecturerEntity.setLecturerEmail(lecturerBean.getLecturerEmail());
	                        lecturerEntities.add(lecturerEntity);
	                    }
	                    courseEntity.setCourseLecturers(lecturerEntities);
	                }

	                courseEntities.add(courseEntity);
	            }
	            stuEnt.setStuCourses(courseEntities);
	        }
		
		stuDao.createStu(stuEnt);
		return null;
	}

	@Override
	public StudentBean getStu(long stuId) {
		// TODO Auto-generated method stub
		StudentEntity stuEnt=stuDao.getStu(stuId);
		if(stuEnt==null)
			System.out.println("No Student Found");
		else
			stuPrint(stuEnt);
		return null;
	}

	@Override
	public String updateStu(StudentBean stuBean) {
		// TODO Auto-generated method stub
		
		StudentEntity stuEnt=new StudentEntity();
		stuEnt.setStudentId(stuBean.getStudentId());
		
		
		stuEnt.setStuName(stuBean.getStuName());
		stuEnt.setStuEmail(stuBean.getStuEmail());
		stuEnt.setStuMobile(stuBean.getStuMobile());
		stuEnt.setStuDob(stuBean.getStuDob());
		stuEnt.setStuGender(stuBean.getStuGender());
		
		if (stuBean.getStuAdd() != null) {
			
			
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressId(stuBean.getStuAdd().getAddressId());
            addressEntity.setArea(stuBean.getStuAdd().getArea());
            addressEntity.setCity(stuBean.getStuAdd().getCity());
            addressEntity.setState(stuBean.getStuAdd().getState());
            addressEntity.setPincode(stuBean.getStuAdd().getPincode());
            stuEnt.setStuAdd(addressEntity);
        }
		
		 if (stuBean.getStuCourses() != null) {
			 
	            List<CourseEntity> courseEntities = new ArrayList<>();
	            for (CourseBean courseBean : stuBean.getStuCourses()) {
	            	
	                CourseEntity courseEntity = new CourseEntity();
	                courseEntity.setCourseId(courseBean.getCourseId());
	                courseEntity.setCourseName(courseBean.getCourseName());
	                courseEntity.setDescription(courseBean.getDescription());
	                courseEntity.setCourseType(courseBean.getCourseType());
	                courseEntity.setCourseDuration(courseBean.getCourseDuration());

	                
	                if (courseBean.getCourseLecturers() != null) {
	                	
	                    List<LecturerEntity> lecturerEntities = new ArrayList<>();
	                    for (LecturerBean lecturerBean : courseBean.getCourseLecturers()) {
	                    	
	                        LecturerEntity lecturerEntity = new LecturerEntity();
	                        lecturerEntity.setLecturerId(lecturerBean.getLecturerId());
	                        lecturerEntity.setLecturerName(lecturerBean.getLecturerName());
	                        lecturerEntity.setLecturerPhone(lecturerBean.getLecturerPhone());
	                        lecturerEntity.setLecturerEmail(lecturerBean.getLecturerEmail());
	                        lecturerEntities.add(lecturerEntity);
	                    }
	                    courseEntity.setCourseLecturers(lecturerEntities);
	                }

	                courseEntities.add(courseEntity);
	            }
	            stuEnt.setStuCourses(courseEntities);
	        }
		 
		stuDao.updateStu(stuEnt);
		return null;
	}

	@Override
	public String deleteStu(long stuId) {
		// TODO Auto-generated method stub
		stuDao.deleteStu(stuId);
		return null;
	}

	@Override
	public void getAllStu() {
		// TODO Auto-generated method stub
		stuDao.getAllStu();
		
	}
	public void stuPrint(StudentEntity stuEnt) {
		
		System.out.println("Student Details:");
		System.out.println("Student Id: "+stuEnt.getStudentId());
	    System.out.println("Name: " + stuEnt.getStuName());
	    System.out.println("Email: " + stuEnt.getStuEmail());
	    System.out.println("Mobile: " + stuEnt.getStuMobile());
	    System.out.println("Date of Birth: " + stuEnt.getStuDob());
	    System.out.println("Gender: " + stuEnt.getStuGender());

	    // Print Address details if present
	    if (stuEnt.getStuAdd() != null) {
	        AddressEntity address = stuEnt.getStuAdd();
	        System.out.println("Address:");
	        System.out.println("Address Id: "+address.getAddressId());
	        System.out.println("\tArea: " + address.getArea());
	        System.out.println("\tCity: " + address.getCity());
	        System.out.println("\tState: " + address.getState());
	        System.out.println("\tPincode: " + address.getPincode());
	    } else {
	        System.out.println("Address: Not available");
	    }

	    // Print Course details if present
	    if (stuEnt.getStuCourses() != null && !stuEnt.getStuCourses().isEmpty()) {
	        System.out.println("Courses:");
	        for (CourseEntity course : stuEnt.getStuCourses()) {
	        	System.out.println("\tCourse Id: "+course.getCourseId());
	            System.out.println("\tCourse Name: " + course.getCourseName());
	            System.out.println("\tCourse Duration: " + course.getCourseDuration());
	            System.out.println("\tCourse Type: " + course.getCourseType());
	            System.out.println("\tDescription: " + course.getDescription());

	            // Print Lecturer details for each course
	            if (course.getCourseLecturers() != null && !course.getCourseLecturers().isEmpty()) {
	                System.out.println("\tLecturers:");
	                for (LecturerEntity lecturer : course.getCourseLecturers()) {
	                	System.out.println("\t\tLecturer Id: "+lecturer.getLecturerId());
	                    System.out.println("\t\tName: " + lecturer.getLecturerName());
	                    System.out.println("\t\tPhone: " + lecturer.getLecturerPhone());
	                    System.out.println("\t\tEmail: " + lecturer.getLecturerEmail());
	                }
	            } else {
	                System.out.println("\tLecturers: Not available");
	            }
	        }
	    } else {
	        System.out.println("Courses: Not available");
	    }
		
	}

}
