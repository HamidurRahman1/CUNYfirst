package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.FAFSA;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentService
{
    @Autowired
    private ApplicationContext applicationContext;
    private final SessionFactory sessionFactory;

    public StudentService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public com.hamidur.cunyfirst.viewTier.models.Student getStudentById(Integer studentId)
    {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, studentId);

        com.hamidur.cunyfirst.viewTier.models.Student viewStudent = Utility.toViewStudent(student);

        viewStudent.setAddress(Utility.toViewAddress(student.getAddresses().iterator().next()));
        viewStudent.setContact(Utility.toViewContact(student.getContact()));
        viewStudent.setLogin(Utility.toViewStudentLogin(student.getLogin()));
        viewStudent.setHighSchoolInfo(Utility.toViewHighSchoolInfo(student.getHighSchoolInfo()));
        viewStudent.setTransferInfo(Utility.toViewTransferInfo(student.getTransferInfo()));
        viewStudent.setLogin(Utility.toViewStudentLogin(student.getLogin()));

        viewStudent.setFafsas(Utility.toViewFafsas(student.getFafsas()));
        viewStudent.setQuestionAnswers(Utility.toViewStudentSecurityQuestionsAns(student.getQuestionAnswers()));
        viewStudent.setStudentCourses(Utility.toViewStudentCourses(student.getStudentCourses()));

        session.close();
        return viewStudent;
    }

    public Student insertStudent(Student daoStudent)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        daoStudent.getAddresses().iterator().next().setStudent(daoStudent);
        daoStudent.getContact().setStudent(daoStudent);
        daoStudent.getHighSchoolInfo().setStudent(daoStudent);
        daoStudent.getTransferInfo().setStudent(daoStudent);

        session.save(daoStudent);

        Login login = createLogin(daoStudent.getPerson(), daoStudent.getStudentId());
        daoStudent.setLogin(login);
        login.setStudent(daoStudent);

        daoStudent.getContact().setCollegeEmail(login.getUserName());

        session.save(login);
        session.update(daoStudent);

        session.getTransaction().commit();
        session.close();

        return daoStudent;
    }

    public void updateStudentsInfo(com.hamidur.cunyfirst.viewTier.models.Student viewStudent)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student daoStudent = session.get(Student.class, viewStudent.getStudentId());

        daoStudent.setStudentId(viewStudent.getStudentId());
        Person person = new Person();
        person.setFirstName(viewStudent.getFirstName());
        person.setLastName(viewStudent.getLastName());
        person.setGender(viewStudent.getGender());
        person.setSsn(viewStudent.getSsn());
        person.setDateOfBirth(Utility.toDaoDOB(viewStudent.getDateOfBirth()));
        daoStudent.setPerson(person);

        Address daoAddress = daoStudent.getAddresses().iterator().next();
        daoAddress.setStreet(viewStudent.getAddress().getStreet());
        daoAddress.setCrossStreet(viewStudent.getAddress().getCrossStreet());
        daoAddress.setCity(viewStudent.getAddress().getCity());
        daoAddress.setState(viewStudent.getAddress().getState());
        daoAddress.setZipCode(viewStudent.getAddress().getZipCode());

        daoStudent.setContact(Utility.toDaoContact(viewStudent.getContact()));
        daoStudent.setHighSchoolInfo(Utility.toDaoHighSchoolInfo(viewStudent.getHighSchoolInfo()));
        daoStudent.setTransferInfo(Utility.toDaoTransferInfo(viewStudent.getTransferInfo()));

        session.saveOrUpdate(daoStudent);
        session.getTransaction().commit();
        session.close();
    }

    public void getStudentBySSN(String ssn)
    {

    }

    public void getStudentByLogin(String userName, String password) {}

    public void getStudents() {}
    
    public void validateLogin(String username, String password)
    {}
    
    public void updateStudentPassword(Integer studentId, String newPassword)
    {}
    
    public void insertStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void getStudentSecurityQuestions(Integer studentId) {}
    
    public void updateStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void insertStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> getStudentFafsas(Integer studentId)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From FAFSA where studentId= :id");
        query.setParameter("id", studentId);
        List<FAFSA> daoFafsas = query.list();

        Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> viewFafsas = new LinkedHashSet<>();

        for(FAFSA fafsa : daoFafsas)
        {
            com.hamidur.cunyfirst.viewTier.models.FAFSA viewFafsa =
                    applicationContext.getBean(com.hamidur.cunyfirst.viewTier.models.FAFSA.class);

            viewFafsa.setTerm(Utility.toViewTerm(fafsa.getTerm()));
            viewFafsa.setAmount(fafsa.getAmount());

            viewFafsas.add(viewFafsa);
        }
        session.close();

        return viewFafsas;
    }
    
    public void updateStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public void insertStudentCourses(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.Course> courses) {}
    
    public void getStudentCourses(Integer studentId) {}

    public boolean isStudentExists(Integer studentId) {return false;}
    public boolean isStudentExists(String ssn) {return false;}
    public boolean isLoginExists(String userName) {return false;}

    public List<com.hamidur.cunyfirst.viewTier.models.Student> getAllStudents() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCourses() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCoursesByTerm
            (com.hamidur.cunyfirst.viewTier.models.Term term)
    {return new LinkedList<>();}

    private Login createLogin(Person person, Integer studentId)
    {
        int i = 6;
        String username = person.getFirstName()+"."+person.getLastName()+String.valueOf(studentId).substring(i);

        Login login = new Login();
        login.setUserName(username);
        login.setActive(false);
        return login;
    }
}
