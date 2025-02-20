package br.com.fiap.fase4produto.config.exception;



import br.com.fiap.fase4produto.features.domain.exception.EstoqueInsuficienteException;
import br.com.fiap.fase4produto.features.domain.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4produto.features.domain.exception.dto.SimpleError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handleClienteNaoEncontradoException(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<SimpleError> handleEstoqueInsuficienteException(EstoqueInsuficienteException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }
}
