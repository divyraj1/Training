package com.fareye.training.Handler;

public class TitleDoesNotExistException extends RuntimeException {

    private String message;

    public TitleDoesNotExistException() {}

    public TitleDoesNotExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
