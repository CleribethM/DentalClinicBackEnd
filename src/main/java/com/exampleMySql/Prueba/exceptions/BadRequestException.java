package com.exampleMySql.Prueba.exceptions;

public class BadRequestException extends Exception{

    public BadRequestException(String message){
        super(message);
    }
}
