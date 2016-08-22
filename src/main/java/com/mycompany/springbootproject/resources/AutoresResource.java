package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.Autor;
import com.mycompany.springbootproject.services.AutorService;
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

@RestController
@RequestMapping("/autores")
public class AutoresResource {

    @Autowired
    private AutorService autorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(autorService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Autor autor) {
        autor = autorService.salvar(autor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Autor> buscar (@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.buscar(id));
    }

}
