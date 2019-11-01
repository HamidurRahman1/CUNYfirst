package com.hamidur.cunyfirst.viewTier.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyHandler
{
    private static final String GENDERS_FILE = "genders.properties";
    private static final String COURSE_LEVELS_FILE = "courseLevels.properties";
    private static final String COUNTRIES_FILE = "countries.properties";
    private static final String STATES_FILE = "states.properties";
    private static final String COURSE_NAMES_FILE = "courseNames.properties";
    private static final String COURSE_CREDITS_FILE = "courseCredits.properties";
    private static final String GRADES_FILE = "grades.properties";
    private static final String QUESTIONS_FILE = "securityQuestions.properties";
    private static final String COURSE_STATUS_FILE = "courseStatus.properties";

    private static Map<String, String> GENDER_MAP = null;
    private static Map<String, String> STATES_MAP = null;
    private static Map<String, String> COUNTRIES_MAP = null;
    private static Map<String, String> COURSE_NAMES_MAP = null;
    private static Map<String, String> GRADES_MAP = null;
    private static Map<String, String> QUESTIONS_MAP = null;
    private static Map<String, String> COURSE_STATUS_MAP = null;
    private static Map<Integer, Integer> COURSE_LEVELS_MAP = null;
    private static Map<Float, Float> COURSE_CREDITS_MAP = null;

    private Map<String, String> generalProperties(final String fileName) throws FileNotFoundException, IOException
    {
        Map<String, String> map = new LinkedHashMap<>();
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null)
        {
            properties.load(inputStream);
        }
        else
        {
            throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
        }

        for (final String name: properties.stringPropertyNames())
            map.put(name, properties.getProperty(name));

        return map;
    }

    public Map<String, String> getGenders() throws FileNotFoundException, IOException
    {
        if(GENDER_MAP == null)
        {
            GENDER_MAP =  generalProperties(GENDERS_FILE);
            return GENDER_MAP;
        }
        else return GENDER_MAP;
    }

    public Map<String, String> getCountries() throws FileNotFoundException, IOException
    {
        if(COUNTRIES_MAP == null)
        {
            COUNTRIES_MAP = generalProperties(COUNTRIES_FILE);
            return COUNTRIES_MAP;
        }
        else return COUNTRIES_MAP;
    }

    public Map<String, String> getStates() throws FileNotFoundException, IOException
    {
        if(STATES_MAP == null)
        {
            STATES_MAP = generalProperties(STATES_FILE);
            return STATES_MAP;
        }
        else return STATES_MAP;
    }

    public Map<String, String> getCourseNames() throws FileNotFoundException, IOException
    {
        if(COURSE_NAMES_MAP == null)
        {
            COURSE_NAMES_MAP = generalProperties(COURSE_NAMES_FILE);
            return COURSE_NAMES_MAP;
        }
        else return COURSE_NAMES_MAP;
    }

    public Map<Integer, Integer> getCourseLevels() throws FileNotFoundException, IOException
    {
       if(COURSE_LEVELS_MAP == null)
       {
           Map<Integer, Integer> map = new LinkedHashMap<>();
           Properties properties = new Properties();
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream(COURSE_LEVELS_FILE);
           if (inputStream != null) {
               properties.load(inputStream);
           } else {
               throw new FileNotFoundException("property file '" + COURSE_LEVELS_FILE + "' not found in the classpath");
           }

           for (final String name : properties.stringPropertyNames())
               map.put(Integer.parseInt(name), Integer.parseInt(properties.getProperty(name)));
           COURSE_LEVELS_MAP = map;
           return COURSE_LEVELS_MAP;
       }
       else return COURSE_LEVELS_MAP;
    }

    public Map<Float, Float> getCourseCredits() throws FileNotFoundException, IOException
    {
        if(COURSE_CREDITS_MAP == null)
        {
            Map<Float, Float> map = new LinkedHashMap<>();
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(COURSE_CREDITS_FILE);
            if(inputStream != null)
            {
                properties.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("property file '" + COURSE_CREDITS_FILE + "' not found in the classpath");
            }

            for (final String name : properties.stringPropertyNames())
                map.put(Float.parseFloat(name), Float.parseFloat(properties.getProperty(name)));
            System.out.println("loaded credits");
            COURSE_CREDITS_MAP = map;
            return COURSE_CREDITS_MAP;
        }
        else return COURSE_CREDITS_MAP;
    }

    public Map<String, String> getGrades() throws FileNotFoundException, IOException
    {
        if(GRADES_MAP == null)
        {
            GRADES_MAP =  generalProperties(GRADES_FILE);
            return GRADES_MAP;
        }
        else return GRADES_MAP;
    }

    public Map<String, String> getQuestions() throws FileNotFoundException, IOException
    {
        if(QUESTIONS_MAP == null)
        {
            QUESTIONS_MAP =  generalProperties(QUESTIONS_FILE);
            return QUESTIONS_MAP;
        }
        else return QUESTIONS_MAP;
    }

    public Map<String, String> getCourseStatus() throws FileNotFoundException, IOException
    {
        if(COURSE_STATUS_MAP == null)
        {
            COURSE_STATUS_MAP =  generalProperties(COURSE_STATUS_FILE);
            return COURSE_STATUS_MAP;
        }
        else return COURSE_STATUS_MAP;
    }

    public final String url = "url";
    public final String methodType = "method";
    public final String displayWho = "displayWho";
    public final String INPUT_ID = "inputId";
    public final String submitText = "submitText";
    public final String MAX = "max";
    public final String MIN = "min";

    public final String POST = "post";
    public final String GET = "get";

    public final String SUB_GET_INSTRUCTOR = "Get Instructor";
    public final String SUB_GET_STUDENT = "Get Student";
    public final String INP_INSTRUCTOR_ID = "instructorId";
    public final String INP_STUDENT_ID = "studentId";
    public final String DIS_INSTRUCTOR_ID = "Instructor ID:";
    public final String DIS_STUDENT_ID = "Student ID:";

}
