package com.jocata.sms.controller;
import java.util.List;
import com.jocata.sms.service.*;
import com.jocata.sms.service.impl.StudentServiceImpl;
import com.jocata.sms.bean.StudentBean;

public class StudentController {
	StudentService stuServ=new StudentServiceImpl();
	public String createStu(StudentBean stuBean){
		stuServ.createStu(stuBean);
		
		return "";
		
	}
	public StudentBean getStu(long stuId){
		stuServ.getStu(stuId);
		
		return null;
	}
	public String updateStu(StudentBean stuBean) {
		stuServ.updateStu(stuBean);
		
		return "";
	}
	public String deleteStu(long stuId) {
		stuServ.deleteStu(stuId);
		
		
		return "";
	}
	public void getAllStu(){
		stuServ.getAllStu();
		
		
	}

}
