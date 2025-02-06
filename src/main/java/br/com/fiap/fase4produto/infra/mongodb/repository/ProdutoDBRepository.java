package br.com.fiap.fase4produto.infra.mongodb.repository;

import br.com.fiap.fase4produto.infra.mongodb.document.cliente.ProdutoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDBRepository extends MongoRepository<ProdutoDocument, String> {
}
