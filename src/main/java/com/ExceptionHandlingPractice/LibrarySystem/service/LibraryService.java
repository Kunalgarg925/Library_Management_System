package com.ExceptionHandlingPractice.LibrarySystem.service;

import com.ExceptionHandlingPractice.LibrarySystem.adapter.LibraryRepository;
import com.ExceptionHandlingPractice.LibrarySystem.models.Book;
import com.ExceptionHandlingPractice.LibrarySystem.models.IssueUnissueExceptionHandler;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    public Student getStudentDetail(String studentId){
        if(studentId == null){
            throw new IllegalArgumentException("Invalid argument");
        }
        return libraryRepository.getStudentDetail(studentId);

    }
    public List<Student> getAllStudent(){
        return libraryRepository.getAllStudents();
    }

    public Book getBookDetail(String bookId) {
        if(bookId == null){
            throw new IllegalArgumentException("Invalid argument");
        }
        return libraryRepository.getBookDetails(bookId);
    }

    public void addBooks(List<Book> bookList){
        System.out.println("add books : " + bookList);
        if(bookList.isEmpty()){
            throw new ArrayStoreException("Empty List");
        }
        libraryRepository.addNewBooks(bookList);
    }

    public void issueBookToStudent(String bookId,String studentId) throws IssueUnissueExceptionHandler {
        System.out.println("book Id : " + bookId + " student Id : " + studentId);
        if(bookId == null && studentId == null){
            throw new IssueUnissueExceptionHandler("Invalid Argument");
        }
        libraryRepository.issueBook(bookId,studentId);
    }

    public void unIssueBook(String bookId) throws IssueUnissueExceptionHandler {
        System.out.println("book Id -> " + bookId);
        if(bookId == null){
            throw new IssueUnissueExceptionHandler("Invalid Argument");
        }
        libraryRepository.unIssueBook(bookId);
    }
}
