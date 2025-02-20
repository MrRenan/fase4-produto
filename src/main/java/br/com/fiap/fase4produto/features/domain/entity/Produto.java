package br.com.fiap.fase4produto.features.domain.entity;

import java.math.BigDecimal;

public class Produto {

    private String id;
    private String nomeProduto;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private int quantidade;

    public Produto(String id, String nomeProduto, String descricao, String categoria, BigDecimal preco, int quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}