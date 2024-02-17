package com.barbosa.rinhabackend.exception;

public class NoCompleteTransactionException extends RuntimeException{

    public NoCompleteTransactionException(String message){
        super(message);
    }

}
