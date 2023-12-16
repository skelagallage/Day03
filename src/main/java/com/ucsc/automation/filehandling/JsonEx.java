package com.ucsc.automation.filehandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucsc.automation.filehandling.dto.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonEx {

    private List<Student> studentList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    private static final String FILE_NAME = "studentData.json";

    {
        studentList.add(new Student("Sanath", 35));
        studentList.add(new Student("Rasara", 25));
        studentList.add(new Student("Siyathma", 24));
    }



    public void createStudentDataJson() throws IOException {

        OutputStream outputStream = new FileOutputStream(FILE_NAME);
        objectMapper.writeValue(outputStream, studentList);
    }

    public void readStudentDataJson() throws IOException {

        InputStream inputStream = new FileInputStream(FILE_NAME);
        List<Student> studentListRead = objectMapper.
                readValue(inputStream, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Student.class));
        for(Student student : studentListRead){
            System.out.println("Student name is " + student.getName() +
                    " and age is " + student.getAge());
        }
    }

    public static void main(String[] args) throws IOException {
//        new JsonEx().createStudentDataJson();
        new JsonEx().readStudentDataJson();
    }

}
