package com.jocata.sms.service;

import com.jocata.sms.bean.LecturerBean;

public interface LecturerService {
	public String createLect(LecturerBean lBean);
	public String getLect(long lectId);
	public String updateLect(LecturerBean lBean);
	public String deleteLect(long lectId);
	public void getAllLect();
}
