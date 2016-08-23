/*
 * @Link do Site de Padrões de retornos: https://tools.ietf.org/html/rfc7231
 */
package com.mycompany.springbootproject.resources;

import com.mycompany.springbootproject.boletos.GeraBoletoTeste;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wmfsystem
 */
@RestController
@RequestMapping(BoletosResource.PATH)
public class BoletosResource {

    protected static final String PATH = "/boletos";

    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    public ResponseEntity<byte[]> buscar() {
        GeraBoletoTeste boletoTeste = new GeraBoletoTeste();
        byte[] file = boletoTeste.arquivo();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "pdf1.pdf";

        headers.add("content-disposition", "inline;filename=" + filename);

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(file, headers, HttpStatus.OK);
        return response;
    }

}
