package br.com.fiap.fase4produto.application.usecase;

import br.com.fiap.fase4produto.features.application.usecase.ProdutoUseCase;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.features.domain.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoUseCaseTest {

    @InjectMocks // Injeta os mocks no ProdutoUseCase
    private ProdutoUseCase produtoUseCase;

    @Mock // Cria um mock de ProdutoService
    private ProdutoService service;

    @BeforeEach
    void setUp() {
        // Inicializa os mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarProduto_DeveRetornarProdutoCriado() {
        // Arrange
        Produto produto = new Produto("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);

        // Configura o comportamento do mock
        when(service.criarProduto(any(Produto.class))).thenReturn(produto);

        // Act
        Produto result = produtoUseCase.criarProduto(produto);

        // Assert
        assertEquals(produto, result);
    }

    @Test
    void obterTodosProdutos_DeveRetornarListaDeProdutos() {
        // Arrange
        Produto produto = new Produto("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);
        List<Produto> expectedProdutos = Collections.singletonList(produto);

        // Configura o comportamento do mock
        when(service.obterTodosProdutos()).thenReturn(expectedProdutos);

        // Act
        List<Produto> result = produtoUseCase.obterTodosProdutos();

        // Assert
        assertEquals(expectedProdutos, result);
    }
}