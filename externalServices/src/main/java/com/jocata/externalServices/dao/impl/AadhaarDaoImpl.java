package com.jocata.externalServices.dao.impl;

import com.jocata.externalServices.dao.AadhaarDao;
import com.jocata.externalServices.entity.Aadhaar;

public class AadhaarDaoImpl implements AadhaarDao {
    @Override
    public Aadhaar getAadhaarInfo(String uid) {
        return new Aadhaar();
    }
}
