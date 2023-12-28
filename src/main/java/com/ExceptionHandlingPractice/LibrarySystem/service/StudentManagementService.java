package com.ExceptionHandlingPractice.LibrarySystem.service;

import com.ExceptionHandlingPractice.LibrarySystem.adapter.StudentRepository;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentManagementService {
    private final StudentRepository studentRepository;

    public StudentManagementService(){
        this.studentRepository = new StudentRepository();
    }
    public Map<String, Student> getStudentList(){
        Map<String,Student> studentsList = studentRepository.getStudentList();
        return studentsList;
    }
}
