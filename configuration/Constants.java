package com.example.bootcamp.configuration;

public class Constants {

    private Constants(){
        throw new IllegalStateException("utility class");
    }
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The technology you want to create already exists";
    public static final String CAPACTITY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The capacity you want to create already exists";
    public static final String TECHNOLOGY_ID_NO_EXISTS_EXCEPTION_MESSAGE = "The technology ID you provided does not exist";
    public static final String TECHNOLOGY_IS_REPEATED = "The technology is repeated";
    public static final String BOOTCAMP_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The bootcamp you want to create already exists";
    public static final String CAPACITY_ID_NO_EXISTS_EXCEPTION_MESSAGE = "The capacity ID you provided does not exist";
    public static final String CAPACITY_IS_REPEATED = "The capacity is repeated";
    public static final String FAILD_SAVE = "Faild to save";
    public static final String FAILD_GET = "Faild to get";
    public static final String VERSION_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The version whit id bootcamp you want to create already exists";
   
}    
