/*
 * @Link do Site de Padrões de retornos: https://tools.ietf.org/html/rfc7231
 */
package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.Comentario;
import com.mycompany.springbootproject.domain.Livro;
import com.mycompany.springbootproject.services.LivroService;
import com.mycompany.springbootproject.services.exceptions.LivroNaoEncontradoException;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author wmfsystem
 */
@RestController
@RequestMapping(LivrosResources.PATH)
public class LivrosResources {

    protected static final String PATH = "/livros";

    @Autowired
    private LivroService livroService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> Salvar(@RequestBody Livro livro) {
        livro = livroService.salvar(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livro.getId()).toUri();
//        ResponseEntity.created(new URI(PATH + "/" + livro.getId())).body(livro);
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Livro livro = livroService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
        livro.setId(id);
        livroService.atualiza(livro);
        livroService.atualiza(livro);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
    public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long livroId, @RequestBody Comentario comentario) {
        livroService.salvarComentario(livroId, comentario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
    public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable Long livroId) {
        List<Comentario> comentarios = livroService.listarComentarios(livroId);
        
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }

}
