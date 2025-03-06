package com.jocata.externalservices.service.impl;

import com.jocata.externalservices.dao.CibilDao;
import com.jocata.externalservices.entity.CibilDetails;
import com.jocata.externalservices.entity.PanDetails;
import com.jocata.externalservices.payload.CibilPayload;
import com.jocata.externalservices.response.CibilResponse;
import com.jocata.externalservices.service.CibilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class CibilServiceImpl implements CibilService {
    @Autowired
    CibilDao cibilDao;
    @Override
    public CibilResponse getCibilInfoDetails(CibilPayload cibilPayload) {
        CibilResponse cibilResponse = new CibilResponse();
        CibilDetails cibil = cibilDao.getCibilInfoDetails(cibilPayload.getPanNumber());
        cibilResponse.setPan(cibil.getPan());
        cibilResponse.setCreditHistory(cibil.getCreditHistory());
        cibilResponse.setStatus(cibil.getStatus());
        cibilResponse.setCreditLimit(String.valueOf(cibil.getCreditLimit()));
        cibilResponse.setCreditScore(String.valueOf(cibil.getCreditScore()));
        cibilResponse.setPaymentHistory(cibil.getPaymentHistory());
        cibilResponse.setRecentCreditInquiries(cibil.getRecentCreditInquiries());
        cibilResponse.setReportDate(cibil.getReportDate().toString());
        cibilResponse.setTotalOutstandingBalance(String.valueOf(cibil.getTotalOutstandingBalance()));
        return cibilResponse;
    }

    @Override
    public Object postCibilInfoDetails(CibilResponse cibilResponse) {
        CibilDetails cibilDetails=new CibilDetails();
        cibilDetails.setPan(cibilResponse.getPan());
        cibilDetails.setCreditHistory(cibilResponse.getCreditHistory());
        cibilDetails.setCreditLimit(BigDecimal.valueOf(Long.valueOf(cibilResponse.getCreditLimit())));
        cibilDetails.setPaymentHistory(cibilResponse.getPaymentHistory());
        cibilDetails.setStatus(cibilResponse.getStatus());
        cibilDetails.setRecentCreditInquiries(cibilResponse.getRecentCreditInquiries());
        cibilDetails.setTotalOutstandingBalance(BigDecimal.valueOf(Long.valueOf(cibilResponse.getTotalOutstandingBalance())));
        cibilDetails.setReportDate(Date.valueOf(cibilResponse.getReportDate()));
        cibilDetails.setCreditScore(Integer.parseInt(cibilResponse.getCreditScore()));


        return cibilDao.postCibilInfoDetails(cibilDetails);
    }
}
