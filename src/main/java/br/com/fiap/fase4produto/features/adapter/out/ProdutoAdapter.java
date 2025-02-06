package br.com.fiap.fase4produto.features.adapter.out;

import br.com.fiap.fase4produto.features.adapter.out.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.features.domain.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4produto.features.port.ProdutoPort;
import br.com.fiap.fase4produto.infra.mongodb.document.cliente.ProdutoDocument;
import br.com.fiap.fase4produto.infra.mongodb.repository.ProdutoDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.fiap.fase4produto.features.domain.exception.ProdutoNaoEncontradoException.produtoNaoEncontradoException;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ProdutoAdapter implements ProdutoPort {

    private final ProdutoDBRepository repository;

    private final ProdutoMapper mapper;


    @Override
    public Produto criarProduto(Produto produto) {

        var clienteDocument = mapper.paraProdutoDocument(produto);
        return mapper.paraProduto(repository.save(clienteDocument));

    }

    @Override
    public Produto obterProdutoPorId(String idCliente) {
        var clienteEntity = repository.findById(idCliente)
                .orElseThrow(ProdutoNaoEncontradoException::produtoNaoEncontradoException);
        return mapper.paraProduto(clienteEntity);
    }

    @Override
    public List<Produto> obterTodosProdutos() {
        return repository.findAll()
                .stream()
                .map(mapper::paraProduto)
                .collect(toList());
    }

    @Override
    public Produto atualizarProduto(String idCliente, Produto produto) {
        if(repository.existsById(idCliente)) {
            ProdutoDocument produtoDocument = repository.save(mapper.paraProdutoDocument(produto));
            return mapper.paraProduto(produtoDocument);
        } else throw produtoNaoEncontradoException();

    }

    @Override
    public void deletarProduto(String idCliente) {
        repository.deleteById(idCliente);
    }

}