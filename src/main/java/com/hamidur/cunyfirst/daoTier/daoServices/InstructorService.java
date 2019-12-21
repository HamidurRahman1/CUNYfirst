package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorCourse;
import com.hamidur.cunyfirst.daoTier.models.InstructorLogin;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;

import com.hamidur.cunyfirst.viewTier.models.StudentCourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Set;

public class InstructorService
{
    private final ApplicationContext applicationContext;
    private final SessionFactory sessionFactory;

    public InstructorService(final HibernateUtility hibernateUtility, final ApplicationContext applicationContext)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
        this.applicationContext = applicationContext;
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

    public com.hamidur.cunyfirst.viewTier.models.Instructor getInstructor(Integer instructorId)
    {
        Session session = sessionFactory.openSession();
        Instructor daoInstructor = session.get(Instructor.class, instructorId);

        com.hamidur.cunyfirst.viewTier.models.Instructor viewInstructor;
        viewInstructor = Utility.toViewInstructor(daoInstructor);

        session.close();

        return viewInstructor;
    }

    private InstructorLogin createLogin(Person person, Integer instructorId)
    {
        String username = person.getFirstName()+"."+person.getLastName()+String.valueOf(instructorId).substring(0, 3);

        InstructorLogin login = new InstructorLogin();
        login.setActive(false);
        login.setUserName(username);
        return login;
    }

    public void updateInstructorInfo(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Instructor daoInstructor = session.get(Instructor.class, instructor.getInstructorId());

        Person person = new Person();
        person.setFirstName(instructor.getFirstName());
        person.setLastName(instructor.getLastName());
        person.setGender(instructor.getGender());
        person.setSsn(instructor.getSsn());
        person.setDateOfBirth(Utility.toDaoDOB(instructor.getDateOfBirth()));
        daoInstructor.setPerson(person);

        session.update(daoInstructor);
        session.getTransaction().commit();
        session.close();
    }

    public Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> getInstructorCoursesByInstructorId(Integer instructorId)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From InstructorCourse where instructorId = :id");
        query.setParameter("id", instructorId);

        List<InstructorCourse> instructorCourses = query.list();

        Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> instructorCourses1 =
                Utility.toViewInstructorCourses(instructorCourses);

        return instructorCourses1;
    }

    public StudentCourse getStudentCourseByInstructorId(Integer instructorId, Integer studentId)
    {
        Session session = sessionFactory.openSession();
        Set<InstructorCourse> instructorCourses = session.get(Instructor.class, instructorId).getInstructorCourses();
        Set<com.hamidur.cunyfirst.daoTier.models.StudentCourse> studentCourseSet =
                session.get(Student.class, studentId).getStudentCourses();

        StudentCourse studentCourse = applicationContext.getBean(StudentCourse.class);

        instructorCourses.forEach(ic ->
        {
            studentCourseSet.forEach(sc ->
            {
                if(sc.getCourse().equals(ic.getCourse()))
                {
                    studentCourse.setStudent(Utility.toViewStudent(sc.getStudent()));
                    studentCourse.setGrade(sc.getGrade());
                    studentCourse.setCourse(Utility.toViewCourse(sc.getCourse()));
                    studentCourse.setCourseStatus(sc.getCourseStatus());
                    studentCourse.setTerm(Utility.toViewTerm(sc.getTerm()));
                    return;
                }
            });
        });

        session.close();
        return studentCourse;
    }
}
