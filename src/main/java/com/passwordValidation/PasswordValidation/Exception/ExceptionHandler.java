package com.passwordValidation.PasswordValidation.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleinvalidargument(MethodArgumentNotValidException ex)
    {
        Map<String, String> listoffieldmessage= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> listoffieldmessage.put(fieldError.getField(),fieldError.getDefaultMessage()));

        return listoffieldmessage;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(Usernamenotfoundexception.class)
    public Map<String,String> handleusernotfoundexception(Usernamenotfoundexception ex)
    {
        Map<String,String> Listoferrors = new HashMap<>();
        Listoferrors.put("ErrorMessage",ex.getMessage());
            return Listoferrors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Map<String,String> handleIncorrectResultSizeDataAccessException (Exception ex)
    {
        Map<String, String> error= new HashMap<>();
        error.put("Something went wrong!!",ex.getMessage());
        return  error;
    }



}
