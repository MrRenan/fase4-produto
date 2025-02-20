package br.com.fiap.fase4produto.features.adapter.out.mapper;

import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterOutMapperProdutoMapperImpl")
)
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto paraProduto(ProdutoDocument produtoDocument);

    ProdutoDocument paraProdutoDocument(Produto produto);

    @Mapping(source = "estoqueAtualizado", target = "quantidade")
    ProdutoDocument atualizarEstoque(ProdutoDocument produtoDocument, int estoqueAtualizado);
}
