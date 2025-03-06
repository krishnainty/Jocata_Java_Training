package com.jocata.externalServices.dao;

import com.jocata.externalServices.bean.PanRequestForm;
import com.jocata.externalServices.bean.PanResponseForm;
import com.jocata.externalServices.entity.Pan;


public interface PanDao {
    public Pan getPanInfo(String panNo);
}
