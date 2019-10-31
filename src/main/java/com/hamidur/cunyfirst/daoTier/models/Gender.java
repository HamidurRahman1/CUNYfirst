package com.hamidur.cunyfirst.daoTier.models;

public enum Gender
{
    M("Male"), F("Female"), O("Other");

    private final String gender;

    Gender(final String gender)
    {
        this.gender = gender;
    }

    public String getValue()
    {
        return gender;
    }
}
