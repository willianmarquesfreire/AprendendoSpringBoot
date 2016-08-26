/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.services;

import com.mycompany.springbootproject.domain.SearchResult;
import com.mycompany.springbootproject.repository.DefaultRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmfsystem
 */
@Service
@Scope(value = "prototype")
public abstract class DefaultService<T extends DefaultRepository> {
    
    @Autowired
    public T repository;
    
    public List<Object> listAll() {
        return repository.findAll();
    }
    
    public void save(Object obj) {
        repository.save(obj);
    }
    
    public Object findOne(Serializable id) {
        return repository.findOne(id);
    }
    //@TODO
    public SearchResult<Object> searchResult() {
        return new SearchResult();
    }
    
}
