package br.com.fiap.fase4produto.infra.mongodb.document.produto;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(collection = "produto")
public record ProdutoDocument(

        @Id String id,
        String nomeProduto,
        String descricao,
        String categoria,
        BigDecimal preco,
        int quantidade

) {
}