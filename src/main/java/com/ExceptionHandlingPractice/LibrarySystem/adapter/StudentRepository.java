package com.ExceptionHandlingPractice.LibrarySystem.adapter;

import com.ExceptionHandlingPractice.LibrarySystem.models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    private final Map<String,Student> studentList = getStudents();

    private Map<String,Student> getStudents() {
        Map<String,Student> studentList = new HashMap<>();
        Student student1 = new Student(1,"kunal","MC101","MCA",null);
        Student student2 = new Student(2,"tushar","MC102","Btech",null);
        Student student3 = new Student(3,"nikhil","MC103","MBA",null);
        Student student4 = new Student(4,"tarun","MC104","Bcom",null);
        studentList.put(student1.getStudentId().toString(),student1);
        studentList.put(student2.getStudentId().toString(),student2);
        studentList.put(student3.getStudentId().toString(),student3);
        studentList.put(student4.getStudentId().toString(),student4);
        return studentList;
    }

    public Map<String,Student> getStudentList() {
        return this.studentList;
    }

}
