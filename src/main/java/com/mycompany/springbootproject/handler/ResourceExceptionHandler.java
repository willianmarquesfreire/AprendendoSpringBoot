package com.mycompany.springbootproject.handler;

import com.mycompany.springbootproject.domain.DetalhesErro;
import com.mycompany.springbootproject.services.exceptions.AutorExistenteException;
import com.mycompany.springbootproject.services.exceptions.AutorNaoEncontradoException;
import com.mycompany.springbootproject.services.exceptions.LivroNaoEncontradoException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro>
            handleLivroNaoEncontadoException(LivroNaoEncontradoException e,
                    HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("O livro não pôde ser encontrado!");
        erro.setMensagemDesenvolvedor("http://error.socialbooks.com/404");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AutorExistenteException.class)
    public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e, HttpServletRequest request) {

        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(409l);
        erro.setTitulo("Autor já existente!");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

    }
    
    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException(AutorExistenteException e, HttpServletRequest request) {

        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("O autor não pôde ser encontrado!");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }

}
