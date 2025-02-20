package br.com.fiap.fase4produto.features.adapter.in.v1;

import br.com.fiap.fase4produto.features.adapter.in.v1.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.application.usecase.ProdutoUseCase;
import br.com.fiap.fase4produto.features.domain.entity.Estoque;
import br.com.fiap.fase4produto.infra.restapi.v1.ProdutoApi;
import br.com.fiap.fase4produto.infra.restapi.v1.model.EstoqueRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoApi {

    private final ProdutoUseCase useCase;
    private final ProdutoMapper mapper;

    @Override
    public ProdutoResponse criarProduto(ProdutoRequest produto) {
        var produtoEntity = useCase.criarProduto(mapper.paraProduto(produto));
        return mapper.paraProdutoResponse(produtoEntity);
    }

    @Override
    public ProdutoResponse obterProdutoPorId(String idProduto) {
        var produto = useCase.obterProdutoPorId(idProduto);
        return mapper.paraProdutoResponse(produto);
    }

    @Override
    public List<ProdutoResponse> obterTodosProdutos() {
        var produtoList =  useCase.obterTodosProdutos();
        return produtoList.stream().map(mapper::paraProdutoResponse).collect(Collectors.toList());
    }

    @Override
    public ProdutoResponse atualizarProduto(String idProduto, ProdutoRequest produto) {
        var produtoEntity = useCase.atualizarProduto(idProduto, mapper.paraProduto(produto));
        return mapper.paraProdutoResponse(produtoEntity);
    }

    @Override
    public void deletarProduto(String idProduto) {
        useCase.deletarProduto(idProduto);
    }

    @Override
    public List<ProdutoResponse> atualizarEstoque(EstoqueRequest estoqueRequest) {

        Estoque estoque = mapper.paraEstoque(estoqueRequest);
        var produtoList = useCase.atualizarEstoque(estoque);
        return produtoList.stream().map(mapper::paraProdutoResponse).collect(Collectors.toList());
    }
}
