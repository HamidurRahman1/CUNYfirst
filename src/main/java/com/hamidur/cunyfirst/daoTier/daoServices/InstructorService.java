package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorLogin;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InstructorService
{
    private final SessionFactory sessionFactory;

    public InstructorService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public Instructor insertInstructor(Instructor daoInstructor)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(daoInstructor);

        session.save(daoInstructor);

        InstructorLogin instructorLogin = createLogin(daoInstructor.getPerson(), daoInstructor.getInstructorId());
        daoInstructor.setLogin(instructorLogin);
        instructorLogin.setInstructor(daoInstructor);

        session.save(instructorLogin);
        session.update(daoInstructor);

        session.getTransaction().commit();

        session.close();

        return daoInstructor;
    }

    public void getInstructor(Integer instructorId)
    {
        Session session = sessionFactory.openSession();
        Instructor daoInstructor = session.get(Instructor.class, instructorId);
        // return instructors
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }

    private InstructorLogin createLogin(Person person, Integer instructorId)
    {
        String username = person.getFirstName()+"."+person.getLastName()+String.valueOf(instructorId).substring(0, 3);

        InstructorLogin login = new InstructorLogin();
        login.setActive(false);
        login.setUserName(username);
        return login;
    }
}
