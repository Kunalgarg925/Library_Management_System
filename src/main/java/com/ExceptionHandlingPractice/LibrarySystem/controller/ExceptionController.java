package com.ExceptionHandlingPractice.LibrarySystem.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Exception.class)
    public void exception(Exception exception){
        System.out.println("Parent Exception handler -> " + exception);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public void exception(RuntimeException exception){
        System.out.println("Child Exception handler -> " + exception);
    }
}
