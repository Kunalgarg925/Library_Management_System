package com.ExceptionHandlingPractice.LibrarySystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Book {
    @JsonProperty("bookId")
    private String bookId;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("bookAuthor")
    private String bookAuthor;
    @JsonProperty("bookEdition")
    private String bookEdition;
    @JsonProperty("bookPrice")
    private Double bookPrice;
    @JsonProperty("issueStudentId")
    private String issueStudentId;
}
