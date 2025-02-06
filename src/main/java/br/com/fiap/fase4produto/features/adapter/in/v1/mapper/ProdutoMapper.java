package br.com.fiap.fase4produto.features.adapter.in.v1.mapper;

import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterInMapperProdutoMapperImpl")
)
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoResponse paraClienteResponse(Produto produto);

    Produto paraCliente(ProdutoRequest produtoRequest);

}