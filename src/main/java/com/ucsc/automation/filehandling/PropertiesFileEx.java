package com.ucsc.automation.filehandling;

import java.io.*;
import java.util.Properties;

public class PropertiesFileEx {

    Properties properties = new Properties();

    private final static String FILE_NAME = "DBProperties.properties";

    public void writeDBProperties() throws IOException {
        try {
            OutputStream outputStream = new FileOutputStream(FILE_NAME);

            properties.setProperty("DBUrl", "MySQL");
            properties.setProperty("port", "3306");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root");
            properties.store(outputStream, null);
            System.out.println("Saved to file successfully");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void readDBProperties() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        properties.load(inputStream);
        System.out.println("DBUrl : " + properties.getProperty("DBUrl"));
        System.out.println("port : " + properties.getProperty("port"));
        System.out.println("username : " + properties.getProperty("username"));
        System.out.println("password : " + properties.getProperty("password"));
    }

    public static void main(String[] args) throws IOException {
//        new PropertiesFileEx().writeDBProperties();
        new PropertiesFileEx().readDBProperties();
    }
}
