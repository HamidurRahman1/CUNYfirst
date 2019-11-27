package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.models.FAFSA;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorCourse;
import com.hamidur.cunyfirst.daoTier.models.InstructorLogin;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.StudentCourse;
import com.hamidur.cunyfirst.daoTier.models.StudentSecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Utility
{
    @Autowired
    private ApplicationContext applicationContext;

    public static com.hamidur.cunyfirst.viewTier.models.Course toViewCourse(Course daoCourse)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Course
                (daoCourse.getCourseId(), daoCourse.getCourseTitle(), daoCourse.getCourseName(),
                daoCourse.getCourseLevel(), daoCourse.getCourseCredits(), daoCourse.getDescription());
    }

    public static Course toDaoCourse(com.hamidur.cunyfirst.viewTier.models.Course course)
    {
        return new Course(course.getCourseTitle(), course.getCourseName(),
                course.getCourseLevel(), course.getCourseCredits(), course.getDescription());
    }

    public static Instructor toDaoInstructor(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        return new Instructor(instructor.getFirstName(), instructor.getLastName(), instructor.getSsn(),
                LocalDate.parse(instructor.getDateOfBirth()), instructor.getGender());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Instructor toViewInstructor(Instructor daoInstructor)
    {
        com.hamidur.cunyfirst.viewTier.models.Instructor instructor =
                new com.hamidur.cunyfirst.viewTier.models.Instructor();

        instructor.setInstructorId(daoInstructor.getInstructorId());
        instructor.setFirstName(daoInstructor.getPerson().getFirstName());
        instructor.setLastName(daoInstructor.getPerson().getLastName());
        instructor.setSsn(daoInstructor.getPerson().getSsn());
        instructor.setDateOfBirth(daoInstructor.getPerson().getDateOfBirth().toString());
        instructor.setGender(daoInstructor.getPerson().getGender());

        return instructor;
    }

    public static Set<InstructorCourse> toDaoInstructorCourses
            (Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> instructorCourses)
    {
        Set<InstructorCourse> courses = new LinkedHashSet<>();

        instructorCourses.forEach(e ->
        {
            InstructorCourse instructorCourse = new InstructorCourse();

            instructorCourse.setCourse(Utility.toDaoCourse(e.getCourse()));
            instructorCourse.setInstructor(Utility.toDaoInstructor(e.getInstructor()));
            instructorCourse.setTerm(Utility.toDaoTerm(e.getTerm()));

            courses.add(instructorCourse);
        });
        return courses;
    }

    private static Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> toViewInstructorCourses
            (Set<InstructorCourse> daoInstructorCourses)
    {
        Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> courses = new LinkedHashSet<>();

        daoInstructorCourses.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.InstructorCourse instructorCourse =
                    new com.hamidur.cunyfirst.viewTier.models.InstructorCourse();

            instructorCourse.setCourse(Utility.toViewCourse(e.getCourse()));
            instructorCourse.setInstructor(Utility.toViewInstructor(e.getInstructor()));
            instructorCourse.setTerm(Utility.toViewTerm(e.getTerm()));

            courses.add(instructorCourse);
        });
        return courses;
    }

    public static Address toDaoAddress(com.hamidur.cunyfirst.viewTier.models.Address address)
    {
        return new Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Address toViewAddress(Address address)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Contact toViewContact(Contact daoContact)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Contact(daoContact.getPhone().getPhone(), daoContact.getEmail(),
                daoContact.getCollegeEmail());
    }

    public static Contact toDaoContact(com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {
        return new Contact(contact.getCollegeEmail(), contact.getEmail(), contact.getPhone());
    }

    private static Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> toViewStudentCourses(Set<StudentCourse> studentCourses)
    {
        Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> studentCourseSet = new LinkedHashSet<>();

        studentCourses.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.StudentCourse studentCourse =
                    new com.hamidur.cunyfirst.viewTier.models.StudentCourse();

            studentCourse.setCourse(toViewCourse(e.getCourse()));
            studentCourse.setCourseStatus(e.getCourseStatus());
            studentCourse.setGrade(e.getGrade());
            studentCourse.setStudent(toViewStudent(e.getStudent()));

            studentCourseSet.add(studentCourse);
        });

        return studentCourseSet;
    }

    private static Set<StudentCourse> toDaoStudentCourses(Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> studentCourses)
    {
        Set<StudentCourse> studentCourseSet = new LinkedHashSet<>();

        studentCourses.forEach(e ->
        {
            StudentCourse studentCourse = new StudentCourse();

            studentCourse.setCourse(toDaoCourse(e.getCourse()));
            studentCourse.setCourseStatus(e.getCourseStatus());
            studentCourse.setGrade(e.getGrade());
            studentCourse.setStudent(toDaoStudent(e.getStudent()));

            studentCourseSet.add(studentCourse);
        });

        return studentCourseSet;
    }

    public static Student toDaoStudent(com.hamidur.cunyfirst.viewTier.models.Student student)
    {
        Student daoStudent = new Student();
        Person person = new Person();

        person.setFirstName(student.getFirstName());
        person.setLastName(student.getLastName());
        person.setSsn(student.getSsn());
        String[] parts = student.getDateOfBirth().split("/");
        person.setDateOfBirth(LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0])));
        person.setGender(student.getGender());

        daoStudent.setPerson(person);

        return daoStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Student toViewStudent(Student student)
    {
        com.hamidur.cunyfirst.viewTier.models.Student viewStudent = new com.hamidur.cunyfirst.viewTier.models.Student();

        viewStudent.setStudentId(student.getStudentId());
        viewStudent.setFirstName(student.getPerson().getFirstName());
        viewStudent.setLastName(student.getPerson().getLastName());
        viewStudent.setSsn(student.getPerson().getSsn());
        viewStudent.setDateOfBirth(student.getPerson().getDateOfBirth().toString());
        viewStudent.setGender(student.getPerson().getGender());

        return viewStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.SecurityQuestion toViewSecurityQuestion(SecurityQuestion securityQuestion)
    {
        return new com.hamidur.cunyfirst.viewTier.models.SecurityQuestion(securityQuestion.getQuestionId(), securityQuestion.getQuestion());
    }

    public static SecurityQuestion toDaoSecurityQuestion(com.hamidur.cunyfirst.viewTier.models.SecurityQuestion securityQuestion)
    {
        return new SecurityQuestion(securityQuestion.getQuestion());
    }

    public static Set<StudentSecurityQuestion> toDaoStudentSecurityQuestionsAns
            (Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> securityQuestionStringMap)
    {
        Set<StudentSecurityQuestion> securityQuestions = new LinkedHashSet<>();

        for(com.hamidur.cunyfirst.viewTier.models.SecurityQuestion securityQuestion: securityQuestionStringMap.keySet())
        {
            StudentSecurityQuestion question = new StudentSecurityQuestion();
            question.setSecurityQuestion(toDaoSecurityQuestion(securityQuestion));

            securityQuestions.add(question);
        }

        return securityQuestions;
    }

    public static Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> toViewStudentSecurityQuestionsAns
            (Set<StudentSecurityQuestion> studentSecurityQuestions)
    {
        Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> securityQuestions = new LinkedHashMap<>();

        studentSecurityQuestions.forEach(e ->
        {
            securityQuestions.put(toViewSecurityQuestion(e.getSecurityQuestion()), e.getAnswer());
        });

        return securityQuestions;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Login toViewStudentLogin(Login daoLogin)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Login(daoLogin.getUserName(), daoLogin.getPassword());
    }

    public static Login toDaoInstructorLogin(com.hamidur.cunyfirst.viewTier.models.Login login)
    {
        return new Login(login.getUsername(), login.getPassword(), login.getActive());
    }

    public static com.hamidur.cunyfirst.viewTier.models.TransferInfo toViewTransferInfo(TransferInfo transferInfo)
    {
        return new com.hamidur.cunyfirst.viewTier.models.TransferInfo
                (transferInfo.getTransferSchoolName(), toViewTerm(transferInfo.getTerm()));
    }

    public static TransferInfo toDaoTransferInfo(com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo)
    {
        if(transferInfo == null) return new TransferInfo();
        return new TransferInfo(transferInfo.getTransferSchoolName(), toDaoTerm(transferInfo.getTerm()));
    }

    public static com.hamidur.cunyfirst.viewTier.models.Term toViewTerm(Term term)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Term(term.getTermName(), term.getTermYear());
    }

    public static Term toDaoTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        return new Term(term.getTermName(), term.getTermYear());
    }

    public static com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo toViewHighSchoolInfo(HighSchoolInfo schoolInfo)
    {
        com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo view =
                new com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo();

        view.setHighSchoolName(schoolInfo.getHighSchoolName());
        view.setCity(schoolInfo.getCity());
        view.setCountry(schoolInfo.getCountry());
        view.setYear(schoolInfo.getYear());

        return view;
    }

    public static HighSchoolInfo toDaoHighSchoolInfo(com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo schoolInfo)
    {
        return new HighSchoolInfo(schoolInfo.getHighSchoolName(), schoolInfo.getYear(), schoolInfo.getCity(),
                schoolInfo.getCountry());
    }

    public static com.hamidur.cunyfirst.viewTier.models.InstructorLogin toViewInstructorLogin(InstructorLogin daoLogin)
    {
        return new com.hamidur.cunyfirst.viewTier.models.InstructorLogin(daoLogin.getUserName(), daoLogin.getPassword());
    }

    public static InstructorLogin toDaoInstructorLogin(com.hamidur.cunyfirst.viewTier.models.InstructorLogin login)
    {
        return new InstructorLogin(login.getUsername(), login.getPassword());
    }

    public static Set<FAFSA> toDaoFafsas(Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas)
    {
        Set<FAFSA> fafsas1 = new LinkedHashSet<>();

        fafsas.forEach(e ->
        {
            FAFSA fafsa = new FAFSA();
            fafsa.setAmount(e.getAmount());
            fafsa.setTerm(toDaoTerm(e.getTerm()));
        });

        return fafsas1;
    }

    public static Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> toViewFafsas
            (Set<FAFSA> fafsas)
    {
        Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas1 = new LinkedHashSet<>();

        fafsas.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.FAFSA fafsa = new com.hamidur.cunyfirst.viewTier.models.FAFSA();
            fafsa.setAmount(e.getAmount());
            fafsa.setTerm(toViewTerm(e.getTerm()));
        });

        return fafsas1;
    }
}
