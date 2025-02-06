package br.com.fiap.fase4produto.features.domain.exception;

import br.com.fiap.fase4produto.features.domain.exception.dto.SimpleError;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ProdutoNaoEncontradoException extends BusinessException {

    private static final String CODIGO = "PRODUTO_NAO_ENCONTRADO";
    private static final String MENSAGEM = "produto não encontrado";
    private static final String DETALHE = "O produto informado não foi encontrado.";

    public ProdutoNaoEncontradoException(SimpleError simpleError) {
        super(NOT_FOUND, simpleError);
    }

    public static ProdutoNaoEncontradoException produtoNaoEncontradoException() {
        var simpleError = new SimpleError(MENSAGEM);
        simpleError.setCode(CODIGO);
        simpleError.setDetails(List.of(DETALHE));
        return new ProdutoNaoEncontradoException(simpleError);
    }
}
