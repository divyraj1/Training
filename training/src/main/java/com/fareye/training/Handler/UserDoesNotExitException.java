package com.fareye.training.Handler;

public class UserDoesNotExitException extends  RuntimeException{

    private String message;

    public UserDoesNotExitException() {}

    public UserDoesNotExitException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
