package br.com.fiap.fase4produto.features.adapter.in.v1;

import br.com.fiap.fase4produto.features.adapter.in.v1.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.application.usecase.ProdutoUseCase;
import br.com.fiap.fase4produto.infra.restapi.v1.ProdutoApi;
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
    public ProdutoResponse obterProdutoPorId(String idCliente) {
        var cliente = useCase.obterProdutoPorId(idCliente);
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest) {
        var cliente = useCase.criarProduto(mapper.paraCliente(produtoRequest));
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public List<ProdutoResponse> obterTodosProdutos() {
        var produtoList =  useCase.obterTodosProdutos();
        return produtoList.stream().map(mapper::paraClienteResponse).collect(Collectors.toList());
    }

    @Override
    public ProdutoResponse atualizarProduto(String idCliente, ProdutoRequest produtoRequest) {
        var cliente = useCase.atualizarProduto(idCliente, mapper.paraCliente(produtoRequest));
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public void deletarProduto(String idCliente) {
        useCase.deletarProduto(idCliente);
    }
}
