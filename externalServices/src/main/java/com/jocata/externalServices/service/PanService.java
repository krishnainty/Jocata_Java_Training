package com.jocata.externalServices.service;
import com.jocata.externalServices.bean.*;
import com.jocata.externalServices.entity.Pan;


public interface PanService {
    PanResponseForm getPanInfo(PanRequestForm pr);

}
