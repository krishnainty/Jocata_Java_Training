package com.jocata.externalservices.dao;

import com.jocata.externalservices.entity.CibilDetails;

public interface CibilDao {
    CibilDetails getCibilInfoDetails(String panNum);

    Object postCibilInfoDetails(CibilDetails cibilDetails);
}
