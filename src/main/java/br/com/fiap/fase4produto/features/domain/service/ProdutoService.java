package br.com.fiap.fase4produto.features.domain.service;

import br.com.fiap.fase4produto.features.adapter.out.ProdutoAdapter;
import br.com.fiap.fase4produto.features.domain.entity.Estoque;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoAdapter adapter;

    public Produto criarProduto(Produto produto) {
        return adapter.criarProduto(produto);
    }

    public Produto obterProdutoPorId(String idProduto) {
        return adapter.obterProdutoPorId(idProduto);
    }

    public List<Produto> obterTodosProdutos() {
        return adapter.obterTodosProdutos();
    }

    public Produto atualizarProduto(String idProduto, Produto produto) {
        return adapter.atualizarProduto(idProduto, produto);
    }

    public void deletarProduto(String idProduto) {
        adapter.deletarProduto(idProduto);
    }

    public List<Produto> atualizarEstoque(Estoque estoque) {
        return adapter.atualizarEstoque(estoque);
    }
}
