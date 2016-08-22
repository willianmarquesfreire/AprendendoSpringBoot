package com.mycompany.springbootproject.services;

import com.mycompany.springbootproject.domain.Autor;
import com.mycompany.springbootproject.repository.AutorRepository;
import com.mycompany.springbootproject.services.exceptions.AutorExistenteException;
import com.mycompany.springbootproject.services.exceptions.AutorNaoEncontradoException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        if (autor.getId() != null) {
            Autor a = autorRepository.findOne(autor.getId());

            if (a != null) {
                throw new AutorExistenteException("O autor já existe!");
            }
        }
        return autorRepository.save(autor);
    }

    public Autor buscar(Long id) {
        Autor autor = autorRepository.findOne(id);

        if (autor == null) {
            throw new AutorNaoEncontradoException("O Autor não pôde ser encontrado!");
        }

        return autor;
    }

}
