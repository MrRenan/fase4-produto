package br.com.fiap.fase4produto.features.domain.entity;

public class ProdutoEstoque {

    private String produtoId;
    private int quantidade;

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoEstoque(String produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public ProdutoEstoque() {
    }

}
