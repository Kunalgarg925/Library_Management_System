package com.ExceptionHandlingPractice.LibrarySystem.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssueUnissueExceptionHandler extends Exception{
    private LocalDateTime exceptionDateTime;
    public IssueUnissueExceptionHandler(String message) {
        super(message);
    }
}
