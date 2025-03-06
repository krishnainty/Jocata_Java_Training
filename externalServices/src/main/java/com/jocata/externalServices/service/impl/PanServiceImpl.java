package com.jocata.externalServices.service.impl;

import com.jocata.externalServices.bean.PanRequestForm;
import com.jocata.externalServices.bean.PanResponseForm;
import com.jocata.externalServices.dao.PanDao;
import com.jocata.externalServices.dao.impl.PanDaoImpl;
import com.jocata.externalServices.entity.Pan;
import com.jocata.externalServices.service.PanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PanServiceImpl implements PanService {
    @Autowired
    private PanDao dao;
    @Override
    public PanResponseForm getPanInfo(PanRequestForm pr) {
        Pan p=dao.getPanInfo(pr.getPanNo());
        if (p == null) {
            return null;
        }

        PanResponseForm prf=new PanResponseForm();

        prf.setPanNo(p.getPanNo());
        prf.setName(p.getName());
        prf.setPanStatus(p.getPanStatus());
        prf.setDob(p.getDob());


        return prf;
    }


}