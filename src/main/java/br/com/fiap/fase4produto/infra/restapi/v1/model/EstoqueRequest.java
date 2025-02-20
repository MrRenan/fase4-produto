package br.com.fiap.fase4produto.infra.restapi.v1.model;

import lombok.Builder;

import java.util.List;

@Builder
public record EstoqueRequest(
    List<ProdutoEstoqueRequest> produtos
) {
    @Builder
    public record ProdutoEstoqueRequest(
            String produtoId,
            int quantidade
    ) {

    }
}
