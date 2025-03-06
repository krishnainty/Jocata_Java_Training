package com.jocata.sms.dao.impl;

import java.util.List;

import com.jocata.sms.dao.StudentDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CourseEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.EntityManagerImpl;

public class StudentDaoImpl implements StudentDao{
	EntityManager eManager=new EntityManagerImpl();
	@Override
	public String createStu(StudentEntity stuEntity) {
		// TODO Auto-generated method stub
		eManager.save(StudentEntity.class, stuEntity);
		System.out.println("Data Successfully saved");
		
		return null;
	}

	@Override
	public StudentEntity getStu(long stuId) {
		// TODO Auto-generated method stub
		List<Object> stuDetails = eManager.get(StudentEntity.class);
		for(Object object : stuDetails) {
			StudentEntity data = (StudentEntity) object;
			if(data.getStudentId()==stuId) {
				return data;
			}
			
		}
		
		return null;
	}

	@Override
	public String updateStu(StudentEntity stuEntity) {
		// TODO Auto-generated method stub
		eManager.update(StudentEntity.class, stuEntity);
		System.out.println("Data Successfully updated");
		return null;
	}

	@Override
	public String deleteStu(long stuId) {
		// TODO Auto-generated method stub
		StudentEntity stuEnt=getStu(stuId);
		eManager.delete(StudentEntity.class, stuEnt);
		System.out.println("Data Successfully deleted");
		return null;
	}

	@Override
	public void getAllStu() {
		// TODO Auto-generated method stub
List<Object> stuDetails = eManager.get(StudentEntity.class);
		
		for(Object object : stuDetails) {
			StudentEntity data = (StudentEntity) object;
			stuPrint(data);			
			
		}
		if(stuDetails.isEmpty()) {
			System.out.println("No Data to Display");
		}
		
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
