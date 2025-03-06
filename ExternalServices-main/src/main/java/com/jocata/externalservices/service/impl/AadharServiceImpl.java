package com.jocata.externalservices.service.impl;

import com.jocata.externalservices.dao.AadharDao;
import com.jocata.externalservices.entity.AadharDetails;
import com.jocata.externalservices.entity.PanDetails;
import com.jocata.externalservices.payload.AadharPayload;
import com.jocata.externalservices.response.AadharResponse;
import com.jocata.externalservices.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AadharServiceImpl implements AadharService {
    @Autowired
    private AadharDao aadharDao;
    @Override
    public AadharResponse getAadharInfoDetails(AadharPayload aadharPayload) {
        AadharResponse aadharResponse=new AadharResponse();
       AadharDetails aadharDetails = aadharDao.getAadharInfoDetails(aadharPayload.getAadharNumber());
        aadharResponse.setAadharNum(aadharDetails.getAadharNum());
        aadharResponse.setAddress(aadharDetails.getAddress());
        aadharResponse.setDob(aadharDetails.getDob().toString());
        aadharResponse.setEmail(aadharDetails.getEmail());
        aadharResponse.setGender(aadharDetails.getGender());
        aadharResponse.setContactNumber(aadharDetails.getContactNumber());
        aadharResponse.setFullName(aadharDetails.getFullName());
        aadharResponse.setIssueDate(aadharDetails.getIssueDate().toString());
        aadharResponse.setStatus(aadharDetails.getStatus());
        return aadharResponse;
    }
}
