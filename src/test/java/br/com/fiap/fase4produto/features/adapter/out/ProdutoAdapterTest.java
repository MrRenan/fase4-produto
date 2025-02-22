package br.com.fiap.fase4produto.features.adapter.out;

import br.com.fiap.fase4produto.features.adapter.out.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import br.com.fiap.fase4produto.infra.mongodb.repository.ProdutoDBRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoAdapterTest {

    @InjectMocks
    private ProdutoAdapter produtoAdapter;

    @Mock
    private ProdutoDBRepository repository;

    @Mock
    private ProdutoMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarProduto_DeveRetornarProdutoCriado() {
        Produto produto = new Produto("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);
        ProdutoDocument produtoDocument = new ProdutoDocument("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);

        when(mapper.paraProdutoDocument(any(Produto.class))).thenReturn(produtoDocument);
        when(repository.save(any(ProdutoDocument.class))).thenReturn(produtoDocument);
        when(mapper.paraProduto(any(ProdutoDocument.class))).thenReturn(produto);

        Produto result = produtoAdapter.criarProduto(produto);

        assertEquals(produto, result);
    }

    @Test
    void obterProdutoPorId_DeveRetornarProduto() {
        Produto produto = new Produto("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);
        ProdutoDocument produtoDocument = new ProdutoDocument("1", "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.valueOf(100), 10);

        when(repository.findById(any(String.class))).thenReturn(Optional.of(produtoDocument));
        when(mapper.paraProduto(any(ProdutoDocument.class))).thenReturn(produto);

        Produto result = produtoAdapter.obterProdutoPorId("1");

        assertEquals(produto, result);
    }
}