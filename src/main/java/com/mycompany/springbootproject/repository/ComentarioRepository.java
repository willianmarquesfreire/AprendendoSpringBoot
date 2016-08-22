package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.domain.Comentario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author willian
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    
}
