package com.ExceptionHandlingPractice.LibrarySystem.controller;

import com.ExceptionHandlingPractice.LibrarySystem.adapter.LogsRepository;
import com.ExceptionHandlingPractice.LibrarySystem.models.IssueUnissueExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("logs")
public class ExceptionController {
    private LogsRepository logsRepository;
    @Autowired
    public ExceptionController(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }
    @ExceptionHandler(value = Exception.class)
    public void exception(Exception exception){
        System.out.println("Parent Exception handler -> " + exception);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public void exception(RuntimeException exception){
        System.out.println("Child Exception handler -> " + exception);
    }
    @ExceptionHandler(value = IssueUnissueExceptionHandler.class)
    public void issueUnissueBookExceptionHandler(IssueUnissueExceptionHandler exception){
        System.out.println("Exception : " + exception);
        exception.setExceptionDateTime(LocalDateTime.now());
        logsRepository.addExceptionLog(exception);
    }

    @GetMapping
    public List<IssueUnissueExceptionHandler> getLogs(){
        return logsRepository.showLogs();
    }
}
