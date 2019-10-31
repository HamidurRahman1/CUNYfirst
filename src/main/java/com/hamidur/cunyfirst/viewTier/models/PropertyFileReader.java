package com.hamidur.cunyfirst.viewTier.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader
{
    private static Map<String, String> genders = null;
    private static Map<String, String> states = null;
    private static Map<String, String> countries = null;
    private static Map<String, String> courseNames = null;
    private static Map<String, String> courseLevels = null;
    private static Map<String, String> grades = null;
    private static Map<String, String> questions = null;
    private static Map<String, String> courseStates = null;

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
        if(genders == null)
        {
            final String gender = "genders.properties";
            genders =  generalProperties(gender);
            return genders;
        }
        else return genders;
    }

    public Map<String, String> getCountries() throws FileNotFoundException, IOException
    {
        if(countries == null)
        {
            final String country = "countries.properties";
            countries = generalProperties(country);
            return countries;
        }
        else return countries;
    }

    public Map<String, String> getStates() throws FileNotFoundException, IOException
    {
        if(states == null)
        {
            final String country = "states.properties";
            states = generalProperties(country);
            return states;
        }
        else return states;
    }

    public Map<String, String> getCourseNames() throws FileNotFoundException, IOException
    {
        if(courseNames == null)
        {
            final String courseName = "courseNames.properties";
            courseNames = generalProperties(courseName);
            return courseNames;
        }
        else return courseNames;
    }

    public Map<String, String> getCourseLevels() throws FileNotFoundException, IOException
    {
        if(courseLevels == null)
        {
            final String courseLevel = "courseLevels.properties";
            courseLevels = generalProperties(courseLevel);
            return courseLevels;
        }
        else return courseLevels;
    }
}
