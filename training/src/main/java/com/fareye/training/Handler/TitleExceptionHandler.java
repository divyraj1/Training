package com.fareye.training.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class TitleExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List> processUnmergeException(final MethodArgumentNotValidException ex) {
        // I am not Clear with this Probably it is Extracting the Error and Sending it in the Form of list
        List list = ex.getBindingResult().getAllErrors().stream()
                    .map(TypeError -> TypeError.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value
            = UserDoesNotExitException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity
    handleUserDoesNotExistsException(
            UserDoesNotExitException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value
            = TitleDoesNotExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity
    titleDoesNotExistsException(
            TitleDoesNotExistException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
