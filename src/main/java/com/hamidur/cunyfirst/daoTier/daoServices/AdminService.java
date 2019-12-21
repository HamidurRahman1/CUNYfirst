package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AdminService
{
    private final ApplicationContext applicationContext;
    private final SessionFactory sessionFactory;

    public AdminService(final HibernateUtility hibernateUtility, final ApplicationContext applicationContext)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
        this.applicationContext = applicationContext;
    }

    public void insertTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        Session session = sessionFactory.openSession();

        Term daoTerm = Utility.toDaoTerm(term);
        session.save(daoTerm);
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }
}
