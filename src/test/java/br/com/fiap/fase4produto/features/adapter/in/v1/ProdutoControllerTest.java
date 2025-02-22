package br.com.fiap.fase4produto.features.adapter.in.v1;

import br.com.fiap.fase4produto.features.adapter.in.v1.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.application.usecase.ProdutoUseCase;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoUseCase useCase;

    @Mock
    private ProdutoMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarProduto_DeveRetornarStatusCreated() {
        ProdutoRequest request = new ProdutoRequest("Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);
        ProdutoResponse response = new ProdutoResponse("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);

        when(mapper.paraProduto(any(ProdutoRequest.class))).thenReturn(new Produto());
        when(useCase.criarProduto(any(Produto.class))).thenReturn(new Produto());
        when(mapper.paraProdutoResponse(any(Produto.class))).thenReturn(response);

        ProdutoResponse result = produtoController.criarProduto(request);
        assertEquals(response, result);
    }

    @Test
    void obterTodosProdutos_DeveRetornarListaDeProdutos() {
        ProdutoResponse response = new ProdutoResponse("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);
        List<ProdutoResponse> expectedResponse = Collections.singletonList(response);

        when(useCase.obterTodosProdutos()).thenReturn(Collections.singletonList(new Produto()));
        when(mapper.paraProdutoResponse(any(Produto.class))).thenReturn(response);

        List<ProdutoResponse> result = produtoController.obterTodosProdutos();
        assertEquals(expectedResponse, result);
    }
}