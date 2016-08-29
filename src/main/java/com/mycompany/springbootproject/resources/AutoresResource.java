package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.domain.Autor;
import com.mycompany.springbootproject.services.AutorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutoresResource extends DefaultResource<AutorService, Autor, Long> {

//    @Autowired
//    private AutorService autorService;
//    
//    // XML : Alterar header -> Accepty -> XML
//    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<Autor>> listar() {
//        List<Autor> autores = autorService.listar();
//        return ResponseEntity.status(HttpStatus.OK).body(autorService.listar());
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor) {
//        autor = autorService.salvar(autor);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(autor.getId()).toUri();
//
//        return ResponseEntity.created(uri).build();
//    }
//    
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Autor> buscar (@PathVariable("id") Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(autorService.buscar(id));
//    }

}
