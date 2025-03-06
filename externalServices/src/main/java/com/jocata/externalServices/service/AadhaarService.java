package com.jocata.externalServices.service;

import com.jocata.externalServices.bean.AadhaarRequestForm;
import com.jocata.externalServices.bean.AadhaarResponseForm;

public interface AadhaarService {
    public AadhaarResponseForm getAadhaarInfo(AadhaarRequestForm ad);
}
