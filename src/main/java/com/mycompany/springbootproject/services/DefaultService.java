/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.services;

import com.mycompany.springbootproject.domain.DefaultDomain;
import com.mycompany.springbootproject.domain.SearchResult;
import com.mycompany.springbootproject.repository.DefaultRepository;
import com.mycompany.springbootproject.services.exceptions.DomainExistenceException;
import com.mycompany.springbootproject.services.exceptions.DomainNotFoundException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmfsystem
 * @param <T> Repositório do Service
 * @param <E> Domain do Service
 */
@Service
@Scope(value = "prototype")
public abstract class DefaultService<T extends DefaultRepository, E extends DefaultDomain> {
    
    @Autowired
    public T repository;
    
    public List<E> listAll() {
        return repository.findAll();
    }
    
    public Object save(E obj) {
        if (obj.getId() != null) {
            E verifyId = (E) repository.findOne(obj.getId());
            
            if (verifyId != null) {
                throw new DomainExistenceException("This Domain exists!");
            }
        }
        obj.setRegistration(new Date(System.currentTimeMillis()));
        obj.setOi("1.");
        return repository.save(obj);
    }
    
    public Object findOne(Serializable id) {
        E object = (E) repository.findOne(id);
        
        if (object == null) {
            throw new DomainNotFoundException("Domain is not found!");
        }
        
        return object;
    }
    //@TODO
    public SearchResult<Object> searchResult() {
        return new SearchResult();
    }
    
    public void delete(Serializable id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Erro ao deletar!");
        }
    }
    
    public void update(E object) {
        verifyExists(object);
        repository.save(object);
    }
    
    public void verifyExists(E object) {
        findOne(object.getId());
    }
    
}
