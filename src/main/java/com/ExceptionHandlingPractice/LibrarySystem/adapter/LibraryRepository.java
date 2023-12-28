package com.ExceptionHandlingPractice.LibrarySystem.adapter;

import com.ExceptionHandlingPractice.LibrarySystem.models.Book;
import com.ExceptionHandlingPractice.LibrarySystem.models.IssueUnissueExceptionHandler;
import com.ExceptionHandlingPractice.LibrarySystem.models.Student;
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

    public void issueBook(String bookId, String studentId) throws IssueUnissueExceptionHandler {
        if(this.studentDetailsList.containsKey(studentId)){
            if(this.bookDetailsList.containsKey(bookId)){
                Book bookDetails = this.bookDetailsList.get(bookId);
                bookDetails.setIssueStudentId(studentId);
                Student studentDetails = this.studentDetailsList.get(studentId);
                List<Book> bookList = studentDetails.getIssuedBooks();
                if(bookList == null ){
                    bookList = new ArrayList<>();
                }
                bookList.add(bookDetails);
                studentDetails.setIssuedBooks(bookList);
                this.studentDetailsList.put(studentId,studentDetails);
                this.bookDetailsList.put(bookId,bookDetails);
            }else{
                throw new IssueUnissueExceptionHandler("Book is issued to another student");
            }
        }else{
            throw new IssueUnissueExceptionHandler("Student Details is not found");
        }
    }

    public void unIssueBook(String bookId) throws IssueUnissueExceptionHandler {
        if(this.bookDetailsList.containsKey(bookId)){
            Book bookDetails = this.bookDetailsList.get(bookId);
            if(bookDetails.getIssueStudentId() != null){
                Student student = this.studentDetailsList.get(bookDetails.getIssueStudentId());
                student.getIssuedBooks().remove(bookDetails);
                this.studentDetailsList.put(String.valueOf(student.getStudentId()),student);
                bookDetails.setIssueStudentId(null);
                this.bookDetailsList.put(bookId,bookDetails);
            }else{
                throw new IssueUnissueExceptionHandler("This book is not issue to any student");
            }
        }else{
            throw new IssueUnissueExceptionHandler("Invalid Book Id");
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(this.studentDetailsList.values().stream().toList());
    }
}
