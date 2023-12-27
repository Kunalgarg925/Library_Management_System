package com.ExceptionHandlingPractice.LibrarySystem.controller;

import com.ExceptionHandlingPractice.LibrarySystem.models.Book;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
import com.ExceptionHandlingPractice.LibrarySystem.service.LibraryService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryManagementController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/StudentId/{studentId}")
    public Student getStudentDetail(@PathVariable ("studentId") String studentId){
        return libraryService.getStudentDetail(studentId);
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return libraryService.getAllStudent();
    }

    @GetMapping("/bookId/{bookId}")
    public Book getBookDetail(@PathVariable("bookId") String bookId){
        return libraryService.getBookDetail(bookId);
    }

    @PostMapping("/addnewbooks/")
    public void addNewBooks(@RequestBody List<Book> bookList){
        libraryService.addBooks(bookList);
    }

    @PostMapping("/issueBook")
    public void issueBook(@RequestParam("bookId") String bookId, @RequestParam("studentId") String studentId){
        libraryService.issueBookToStudent(bookId,studentId);
    }
}
