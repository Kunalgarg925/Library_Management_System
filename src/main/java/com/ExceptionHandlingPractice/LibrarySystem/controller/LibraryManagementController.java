package com.ExceptionHandlingPractice.LibrarySystem.controller;

import com.ExceptionHandlingPractice.LibrarySystem.models.Book;
import com.ExceptionHandlingPractice.LibrarySystem.models.IssueUnissueExceptionHandler;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
import com.ExceptionHandlingPractice.LibrarySystem.service.LibraryService;
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
    public void issueBook(@RequestParam("bookId") String bookId, @RequestParam("studentId") String studentId) throws IssueUnissueExceptionHandler {
        libraryService.issueBookToStudent(bookId,studentId);
    }
    @PostMapping("/unissueBook")
    public void unIssueBook(@RequestParam("bookId") String bookId) throws IssueUnissueExceptionHandler {
        libraryService.unIssueBook(bookId);
    }
}
