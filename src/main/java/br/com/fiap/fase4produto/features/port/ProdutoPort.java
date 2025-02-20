package br.com.fiap.fase4produto.features.port;

import br.com.fiap.fase4produto.features.domain.entity.Estoque;
import br.com.fiap.fase4produto.features.domain.entity.Produto;

import java.util.List;

public interface ProdutoPort {

    Produto criarProduto(Produto produto);

    Produto obterProdutoPorId(String idProduto);

    List<Produto> obterTodosProdutos();

    Produto atualizarProduto(String idProduto, Produto produto);

    void deletarProduto(String idProduto);

    List<Produto> atualizarEstoque(Estoque estoque);
}
