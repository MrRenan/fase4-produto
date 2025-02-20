package br.com.fiap.fase4produto.features.domain.entity;

import java.util.List;


public class Estoque {

    private List<ProdutoEstoque> produtos;

    public List<ProdutoEstoque> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }

    public Estoque(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }

    public Estoque() {
    }

}