package br.com.fiap.fase4produto.infra.restapi.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Batch", description = "Operações relacionadas a execução do Spring Batch")
@RequestMapping("/v1/batch")
public interface BatchApi {

    @Operation(summary = "Executar Spring Batch")
    @GetMapping("/executar")
    @ResponseStatus(HttpStatus.OK)
    String executarSpringBatch() throws Exception;
}
