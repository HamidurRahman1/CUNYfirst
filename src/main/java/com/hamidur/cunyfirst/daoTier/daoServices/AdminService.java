package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.AdminLogin;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public Admin getAdminByLogin(String username, String password)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From AdminLogin where userName = :un and password = :pass");
        query.setParameter("un", username);
        query.setParameter("pass", password);

        AdminLogin daoLogin = (AdminLogin)query.getResultList().iterator().next();

        Admin admin1 = applicationContext.getBean(Admin.class);

        admin1.setAdminId(daoLogin.getAdmin().getAdminId());
        admin1.setFirstName(daoLogin.getAdmin().getPerson().getFirstName());
        admin1.setLastName(daoLogin.getAdmin().getPerson().getLastName());
        session.close();

        return admin1;
    }
}
