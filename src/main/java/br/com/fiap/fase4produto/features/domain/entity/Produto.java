package br.com.fiap.fase4produto.features.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Produto {

    private String id;
    private String nomeProduto;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private int quantidade;

}