/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.DefaultDomain;
import com.mycompany.springbootproject.domain.Response;
import com.mycompany.springbootproject.services.DefaultService;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author wmfsystem
 * @param <T>
 */
@RestController
public class DefaultResource<T extends DefaultService, E extends DefaultDomain, D extends Serializable> {

    @Autowired
    public T service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<?>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody E object) {
        object = (E) service.save(object);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(object.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable D id) {
        Object object = service.findOne(id);
        CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(object);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable D id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody E object, @PathVariable("id") Serializable id) {
        object.setId(id);
        service.update(object);
        return ResponseEntity.noContent().build();
    }
    
    
    
    

}
