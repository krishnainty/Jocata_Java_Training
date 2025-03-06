package com.jocata.externalServices.dao.impl;

import com.jocata.externalServices.bean.PanRequestForm;
import com.jocata.externalServices.bean.PanResponseForm;
import com.jocata.externalServices.dao.PanDao;
import com.jocata.externalServices.entity.Pan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;


public class PanDaoImpl implements PanDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Pan getPanInfo(String panNo) {
        String queryStr = "SELECT p FROM Pan p WHERE p.panNo = :panNo";
        TypedQuery<Pan> query = em.createQuery(queryStr, Pan.class);
        query.setParameter("panNo", panNo);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
