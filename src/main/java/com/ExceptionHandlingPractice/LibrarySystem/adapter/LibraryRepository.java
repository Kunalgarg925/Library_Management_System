package com.ExceptionHandlingPractice.LibrarySystem.adapter;

import com.ExceptionHandlingPractice.LibrarySystem.models.Book;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
import com.ExceptionHandlingPractice.LibrarySystem.service.StudentManagementService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LibraryRepository {
    private final StudentRepository studentRepository;

    private final Map<String,Student> studentDetailsList;
    private final Map<String, Book> bookDetailsList;
    public LibraryRepository() {
        this.studentRepository = new StudentRepository();
        this.studentDetailsList = studentRepository.getStudentList();
        this.bookDetailsList = new HashMap<>();
    }

    public Student getStudentDetail(String studentId){
        if(!this.studentDetailsList.containsKey(studentId)){
            throw new RuntimeException("Student not Found");
        }
        return this.studentDetailsList.get(studentId);
    }

    public Book getBookDetails(String bookId) {
        if(!this.bookDetailsList.containsKey(bookId)){
            throw new RuntimeException("Book not listed in database");
        }
        return this.bookDetailsList.get(bookId);
    }

    public void addNewBooks(List<Book> bookList) {
        for(Book iterateBook : bookList){
            this.bookDetailsList.put(iterateBook.getBookId(),iterateBook);
        }
    }

    public void issueBook(String bookId, String studentId) {
        if(this.studentDetailsList.containsKey(studentId)){
            if(this.bookDetailsList.containsKey(bookId)){
                Book bookDetails = this.bookDetailsList.get(bookId);
                bookDetails.setIssueStudentId(studentId);
                Student studentDetails = this.studentDetailsList.get(studentId);
                List<Book> bookList = studentDetails.getIssuedBooks();
                if(bookList != null ){
                    bookList.add(bookDetails);
                }else{
                    bookList = new ArrayList<>();
                    bookList.add(bookDetails);
                }
                studentDetails.setIssuedBooks(bookList);
                this.studentDetailsList.put(studentId,studentDetails);
                this.bookDetailsList.put(bookId,bookDetails);
            }else{
                throw new RuntimeException("Book is issued to another student");
            }
        }else{
            throw new RuntimeException("Student Details is not found");
        }
    }

    public void unIssueBook(String bookId) {
        if(this.bookDetailsList.containsKey(bookId)){
            Book bookDetails = this.bookDetailsList.get(bookId);
            if(bookDetails.getIssueStudentId() != null){
                bookDetails.setIssueStudentId(null);
            }else{
                throw new RuntimeException("This book is not issue to any student");
            }
        }else{
            throw new RuntimeException("Invalid Book Id");
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(this.studentDetailsList.values().stream().toList());
    }
}
