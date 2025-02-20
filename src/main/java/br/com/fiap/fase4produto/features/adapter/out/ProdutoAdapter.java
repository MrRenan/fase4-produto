package br.com.fiap.fase4produto.features.adapter.out;

import br.com.fiap.fase4produto.features.adapter.out.mapper.ProdutoMapper;
import br.com.fiap.fase4produto.features.domain.entity.Estoque;
import br.com.fiap.fase4produto.features.domain.entity.Produto;
import br.com.fiap.fase4produto.features.domain.exception.EstoqueInsuficienteException;
import br.com.fiap.fase4produto.features.domain.exception.ProdutoNaoEncontradoException;
import br.com.fiap.fase4produto.features.port.ProdutoPort;
import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import br.com.fiap.fase4produto.infra.mongodb.repository.ProdutoDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));
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
        } else throw new ProdutoNaoEncontradoException("Produto não encontrado");

    }

    @Override
    public void deletarProduto(String idProduto) {
        repository.deleteById(idProduto);
    }

    @Override
    public List<Produto> atualizarEstoque(Estoque estoque) {
        return estoque.getProdutos()
                .stream()
                .map(produtoEstoque -> {
                    ProdutoDocument produtoDocument = repository.findById(produtoEstoque.getProdutoId())
                            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));
                    int estoqueAtualizado = produtoDocument.quantidade() - produtoEstoque.getQuantidade();
                    if(estoqueAtualizado < 0) {
                        throw new EstoqueInsuficienteException("Estoque insuficinte.");
                    }
                    ProdutoDocument produtoComEstoqueAtualizado = mapper.atualizarEstoque(produtoDocument, estoqueAtualizado);
                    return repository.save(produtoComEstoqueAtualizado);
                }).map(mapper::paraProduto)
                .toList();
    }

}