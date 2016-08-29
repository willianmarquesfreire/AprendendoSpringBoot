/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.Teste;
import com.mycompany.springbootproject.services.TesteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wmfsystem
 */
@RestController
@RequestMapping("/teste")
public class TesteResource extends DefaultResource<TesteService, Teste, Long> {

}
