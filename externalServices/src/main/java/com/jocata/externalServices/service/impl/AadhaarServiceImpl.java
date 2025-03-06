package com.jocata.externalServices.service.impl;

import com.jocata.externalServices.bean.*;
import com.jocata.externalServices.dao.AadhaarDao;
import com.jocata.externalServices.dao.impl.AadhaarDaoImpl;
import com.jocata.externalServices.entity.Aadhaar;
import com.jocata.externalServices.service.AadhaarService;

public class AadhaarServiceImpl implements AadhaarService {

    @Override
    public AadhaarResponseForm getAadhaarInfo(AadhaarRequestForm ad) {
        AadhaarDao aadhaarDao=new AadhaarDaoImpl();
        AadhaarResponseForm aadhaarResponse=new AadhaarResponseForm();
        Aadhaar aadhaarData=aadhaarDao.getAadhaarInfo(ad.getUidNumber());
        Demographic demo=new Demographic();
        demo.setDob(aadhaarData.getDob());
        demo.setName(aadhaarData.getName());
        demo.setGender(aadhaarData.getGender());
        Address add=new Address();
        add.setAddressLine1(aadhaarData.getAddressLine1());
        add.setAddressLine2(aadhaarData.getAddressLine2());
        add.setDistrict(aadhaarData.getDistrict());
        add.setState(aadhaarData.getState());
        add.setPinCode(aadhaarData.getPinCode());
        demo.setAdd(add);
        aadhaarResponse.setDemographic(demo);
        Uid uid=new Uid();
        uid.setUidNumber(aadhaarData.getUidNumber());
        aadhaarResponse.setUid(uid);
        Photo photo=new Photo();
        photo.setImageData(aadhaarData.getImageData());
        aadhaarResponse.setPhoto(photo);
        Mobile mobile=new Mobile();
        mobile.setMobile(aadhaarData.getMobile());
        mobile.setMaskedMobile(aadhaarData.getMaskedMobile());
        mobile.setHashedMobile(aadhaarData.getHashedMobile());
        aadhaarResponse.setMobile(mobile);
        Email email=new Email();
        email.setEmail(aadhaarData.getEmail());
        email.setHashedEmail(aadhaarData.getHashedEmail());
        email.setMaskedEmail(aadhaarData.getMaskedMobile());
        aadhaarResponse.setEmail(email);



        return aadhaarResponse;
    }
}
