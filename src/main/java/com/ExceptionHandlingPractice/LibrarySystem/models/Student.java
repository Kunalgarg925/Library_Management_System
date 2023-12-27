package com.ExceptionHandlingPractice.LibrarySystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
    private String studentRollNumber;
    private String studentCourse;
    private List<Book> issuedBooks;
}
