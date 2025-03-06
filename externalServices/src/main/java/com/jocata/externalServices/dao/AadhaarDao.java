package com.jocata.externalServices.dao;

import com.jocata.externalServices.bean.AadhaarRequestForm;
import com.jocata.externalServices.bean.AadhaarResponseForm;
import com.jocata.externalServices.entity.Aadhaar;

public interface AadhaarDao {
    public Aadhaar getAadhaarInfo(String uid);
}
