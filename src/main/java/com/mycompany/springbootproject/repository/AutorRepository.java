package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.domain.Autor;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends DefaultRepository<Autor, Long> {
    
}
