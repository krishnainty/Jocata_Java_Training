package com.jocata.externalservices.dao.impl;

import com.jocata.externalservices.dao.CibilDao;
import com.jocata.externalservices.entity.CibilDetails;
import com.jocata.externalservices.entity.PanDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CibilDaoImpl implements CibilDao {
    private final SessionFactory sessionFactory;

    public CibilDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CibilDetails getCibilInfoDetails(String panNum) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CibilDetails c WHERE c.pan = :pan";
        Query<CibilDetails> query = session.createQuery(hql, CibilDetails.class);
        query.setParameter("pan", panNum);

        return query.uniqueResult();

    }

    @Override
    public Object postCibilInfoDetails(CibilDetails cibilDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cibilDetails);
        return "Success";
    }
}
