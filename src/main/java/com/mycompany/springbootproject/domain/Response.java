/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.domain;

import java.util.List;

/**
 *
 * @author wmfsystem
 */
public class Response {

    public String message;
    public Object object;
    public List<Exception> exceptions;

    public Response() {
    }

    public Response(String message, Object object, List<Exception> exceptions) {
        this.message = message;
        this.object = object;
        this.exceptions = exceptions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

}
