package br.com.fiap.fase4produto.infra.restapi.v1;

import br.com.fiap.fase4produto.infra.restapi.v1.model.EstoqueRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoRequest;
import br.com.fiap.fase4produto.infra.restapi.v1.model.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "Produto", description = "Operações relacionadas ao dominio de produto")
@RequestMapping(path = ("/v1/produto"))
public interface ProdutoApi {

    @Operation(summary = "Criar produto.")
    @PostMapping
    @ResponseStatus(CREATED)
    ProdutoResponse criarProduto(@RequestBody ProdutoRequest produto);

    @Operation(summary = "Obter produto por id")
    @GetMapping("/{idProduto}")
    @ResponseStatus(OK)
    ProdutoResponse obterProdutoPorId(@PathVariable("idProduto") String idProduto);

    @Operation(summary = "Obter todos os produto.")
    @GetMapping
    @ResponseStatus(OK)
    List<ProdutoResponse> obterTodosProdutos();

    @Operation(summary = "Atualizar um produto por id.")
    @PutMapping("/{idProduto}")
    @ResponseStatus(OK)
    ProdutoResponse atualizarProduto(@PathVariable("idProduto") String idProduto, @RequestBody ProdutoRequest produto);

    @Operation(summary = "Deletar um produto por id")
    @DeleteMapping("/{idProduto}")
    @ResponseStatus(NO_CONTENT)
    void deletarProduto(@PathVariable("idProduto") String idProduto);

    @Operation(summary = "Atualizar o estoque")
    @PutMapping("/estoque")
    @ResponseStatus(NO_CONTENT)
    List<ProdutoResponse> atualizarEstoque(@RequestBody EstoqueRequest estoqueRequest );

}
