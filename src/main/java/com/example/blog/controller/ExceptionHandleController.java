package com.example.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RestController
public class ExceptionHandleController {

    /*
    * to send the error message of validation like
    * field = error message
    * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> result = new HashMap<>();

        //get all error messages
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            //to get the field(variable of object) error occur
            String field = ((FieldError)error).getField();
            //to get error message
            String message = error.getDefaultMessage();
            result.put(field,message);
        });
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
