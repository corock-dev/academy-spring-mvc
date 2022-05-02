package com.nhnacademy.springmvc.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.nhnacademy.springmvc.exception.UserAlreadyExistsException;
import com.nhnacademy.springmvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleException(UserAlreadyExistsException exc, Model model) {
        model.addAttribute("exception", exc);
        return "error";
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException() {
        return;
        // return ""
    }
}
