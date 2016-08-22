package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wmfsystem
 */
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
