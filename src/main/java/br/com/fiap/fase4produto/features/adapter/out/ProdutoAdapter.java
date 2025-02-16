package br.com.fiap.fase4produto.features.adapter.out;

import br.com.fiap.fase4produto.features.adapter.out.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.features.domain.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4produto.features.port.ProdutoPort;
import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
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

        var produtoDocument = mapper.paraProdutoDocument(produto);
        return mapper.paraProduto(repository.save(produtoDocument));

    }

    @Override
    public Produto obterProdutoPorId(String idProduto) {
        var produtoEntity = repository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::produtoNaoEncontradoException);
        return mapper.paraProduto(produtoEntity);
    }

    @Override
    public List<Produto> obterTodosProdutos() {
        return repository.findAll()
                .stream()
                .map(mapper::paraProduto)
                .collect(toList());
    }

    @Override
    public Produto atualizarProduto(String idProduto, Produto produto) {
        if(repository.existsById(idProduto)) {
            produto.setId(idProduto);
            ProdutoDocument produtoDocument = repository.save(mapper.paraProdutoDocument(produto));
            return mapper.paraProduto(produtoDocument);
        } else throw produtoNaoEncontradoException();

    }

    @Override
    public void deletarProduto(String idProduto) {
        repository.deleteById(idProduto);
    }

}