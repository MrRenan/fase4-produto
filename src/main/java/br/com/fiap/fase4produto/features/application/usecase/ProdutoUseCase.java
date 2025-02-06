package br.com.fiap.fase4produto.features.application.usecase;

import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.features.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoUseCase {

    @Autowired
    private ProdutoService service;

    public Produto criarProduto(Produto produto) {
        return service.criarProduto(produto);
    }

    public Produto obterProdutoPorId(String idProdduto) {
        return service.obterProdutoPorId(idProdduto);
    }

    public List<Produto> obterTodosProdutos() {
        return service.obterTodosProdutos();
    }

    public Produto atualizarProduto(String idProdduto, Produto produto) {
        return service.atualizarProduto(idProdduto, produto) ;
    }

    public void deletarProduto(String idProdduto) {
        service.deletarProduto(idProdduto);
    }
}
