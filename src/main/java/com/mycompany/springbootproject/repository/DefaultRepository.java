/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.domain.DefaultDomain;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author wmfsystem
 * @param <T> Tipo genérico
 * @param <ID> Identificação
 */
@NoRepositoryBean
public interface DefaultRepository<T extends DefaultDomain, ID extends Serializable> extends JpaRepository<T, ID> {
   
}
