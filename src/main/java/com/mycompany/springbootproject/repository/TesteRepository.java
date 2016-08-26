/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.domain.Teste;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wmfsystem
 */
@Repository
public interface TesteRepository extends DefaultRepository<Teste, Long>{
    
}
