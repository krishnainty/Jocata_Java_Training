package com.jocata.sms.Main;
import java.util.ArrayList;
import java.util.List;

import com.jocata.sms.bean.*;
import com.jocata.sms.controller.StudentController;

public class StudentStart {
	public static void main(String args[]) {
		
		StudentController stuCon=new StudentController();
		
	    StudentBean stuBean = new StudentBean();
	    //stuBean.setStudentId(1);
	    stuBean.setStuName("krishna");
	    stuBean.setStuEmail("abc@gmail.com");
	    stuBean.setStuMobile("123456789");
	    stuBean.setStuDob("2000-01-01");
	    stuBean.setStuGender("Male");

	    AddressBean addressBean = new AddressBean();
	    addressBean.setArea("madhapur");
	    addressBean.setCity("hyd");
	    addressBean.setState("Telangana");
	    addressBean.setPincode("2349");
	    stuBean.setStuAdd(addressBean);

	    
	    
	    CourseBean courBean=new CourseBean();
		//courBean.setCourseId(6882);
		courBean.setCourseDuration("1 year");
		courBean.setCourseName("CSE");
		courBean.setCourseType("Full time");
		courBean.setDescription("This is a full time jave course");
		List<LecturerBean>lBeanList=new ArrayList<>();
		LecturerBean lBean=new LecturerBean();
		lBean.setLecturerName("ravi");
		lBean.setLecturerPhone("1234");
		lBean.setLecturerEmail("123@gmail");
		lBeanList.add(lBean);
		LecturerBean lBean2=new LecturerBean();
		lBean2.setLecturerName("hari");
		lBean2.setLecturerPhone("1234");
		lBean2.setLecturerEmail("123@gmail");
		lBeanList.add(lBean2);
		
		
		courBean.setCourseLecturers(lBeanList);

	    List<CourseBean> courses = new ArrayList<>();
	    courses.add(courBean);
	    stuBean.setStuCourses(courses);
	    
	   // stuCon.createStu(stuBean);
	    //stuCon.getStu(2523);
	    //stuCon.updateStu(stuBean);
	    //stuCon.deleteStu(0);
	    stuCon.getAllStu();
	    
	    
		
	}

}
