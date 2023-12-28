package com.ExceptionHandlingPractice.LibrarySystem.adapter;

import com.ExceptionHandlingPractice.LibrarySystem.models.IssueUnissueExceptionHandler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogsRepository {
    private final List<IssueUnissueExceptionHandler> exceptionLogs = new ArrayList<>();

    public void addExceptionLog(IssueUnissueExceptionHandler newExceptionLog){
        this.exceptionLogs.add(newExceptionLog);
    }
    public List<IssueUnissueExceptionHandler> showLogs(){

        return this.exceptionLogs;
    }
}
