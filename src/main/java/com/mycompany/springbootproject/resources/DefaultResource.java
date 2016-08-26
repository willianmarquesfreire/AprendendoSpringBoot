/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.Response;
import com.mycompany.springbootproject.services.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wmfsystem
 * @param <T>
 */
@RestController
public class DefaultResource<T extends DefaultService> {
    
    @Autowired
    public T service;
    
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Response> 
    
}
