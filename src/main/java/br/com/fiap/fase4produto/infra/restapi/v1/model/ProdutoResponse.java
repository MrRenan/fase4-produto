package br.com.fiap.fase4produto.infra.restapi.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(title = "ProdutoV1ProdutoResponse")
public record ProdutoResponse(
        String id,
        String nomeProduto,
        String descricao,
        String categoria,
        BigDecimal preco,
        int quantidade
) {

}