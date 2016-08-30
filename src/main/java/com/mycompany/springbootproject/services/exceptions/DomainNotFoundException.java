package com.mycompany.springbootproject.services.exceptions;

public class DomainNotFoundException extends RuntimeException{
    
    public DomainNotFoundException(String message) {
        super(message);
    }
    
    public DomainNotFoundException(String message, Throwable causa) {
        super(message, causa);
    }
    
}
