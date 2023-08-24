package com.online.Smart_Online_Shopping_Platform.exception;

public class EmptyCartException extends RuntimeException{

    public EmptyCartException(String message){
        super(message);
    }
}
