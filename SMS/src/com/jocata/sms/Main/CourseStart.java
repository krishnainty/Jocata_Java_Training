package com.jocata.sms.Main;

import java.util.ArrayList;
import java.util.List;

import com.jocata.sms.bean.*;
import com.jocata.sms.controller.CourseController;

public class CourseStart {
	public static void main(String args[]) {
		CourseController courCon=new CourseController();
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
		//courCon.createCour(courBean);
		//courCon.getCour(6882);
		//courCon.updateCour(courBean);
		courCon.deleteCour(0);
		courCon.getAllCour();
		
	}

}
