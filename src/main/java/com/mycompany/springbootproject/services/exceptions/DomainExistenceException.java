package com.mycompany.springbootproject.services.exceptions;

public class DomainExistenceException extends RuntimeException{
    
    public DomainExistenceException(String message) {
        super(message);
    }
    
    public DomainExistenceException(String message, Throwable causa) {
        super(message, causa);
    }
    
}
