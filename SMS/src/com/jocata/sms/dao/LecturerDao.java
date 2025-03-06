package com.jocata.sms.dao;

import com.jocata.sms.bean.LecturerBean;
import com.jocata.sms.entity.LecturerEntity;

public interface LecturerDao {
	public String createLect(LecturerEntity lEntity);
	public String getLect(long lectId);
	public String updateLect(LecturerEntity lEntity);
	public String deleteLect(long lectId);
	public void getAllLect();

}
