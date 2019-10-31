package com.hamidur.cunyfirst.viewTier.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Map;

@Configuration
@PropertySources(value =
        {@PropertySource("classpath:countries.properties"),
        @PropertySource("classpath:courseLevels.properties"),
        @PropertySource("classpath:courseNames.properties"),
        @PropertySource("classpath:courseStatus.properties"),
        @PropertySource("classpath:grades.properties"),
        @PropertySource("classpath:gender.properties")})
public class PropertyFileReader
{
    private Map<String, String> genderOptions;

    private Map<String, String> countryOptions;

    private Map<String, String> stateOptions;
}
