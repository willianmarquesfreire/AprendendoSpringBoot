/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wmfsystem
 */
@RestController
@RequestMapping("/security")
public class Security {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String access(@PathVariable Long id) {
        return "true";
    }
    
}
