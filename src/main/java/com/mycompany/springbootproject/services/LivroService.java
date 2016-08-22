package com.mycompany.springbootproject.services;

import com.mycompany.springbootproject.domain.Comentario;
import com.mycompany.springbootproject.domain.Livro;
import com.mycompany.springbootproject.repository.ComentarioRepository;
import com.mycompany.springbootproject.repository.LivroRepository;
import com.mycompany.springbootproject.services.exceptions.LivroNaoEncontradoException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author wmfsystem
 */
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro buscar(Long id) {
        Livro livro = livroRepository.findOne(id);

        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro não pode ser encontrado!");
        }

        return livro;

    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        try {
            livroRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEncontradoException("O livro não pode ser encontrado!");
        }
    }

    public void atualiza(Livro livro) {
        verificarExistencia(livro);
        livroRepository.save(livro);
    }

    public void verificarExistencia(Livro livro) {
        buscar(livro.getId());
    }

    public Comentario salvarComentario(Long livroId, Comentario comentario) {
        Livro livro = buscar(livroId);

        comentario.setLivro(livro);
        comentario.setData(new Date());

        return comentarioRepository.save(comentario);
    }
    
    public List<Comentario> listarComentarios(Long livroId) {
        Livro livro = buscar(livroId);
        return livro.getComentarios();
    }

}
