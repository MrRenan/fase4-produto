package br.com.fiap.fase4produto.infra.springbatch;

import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProcessor implements ItemProcessor<ProdutoDocument, ProdutoDocument> {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoProcessor.class);

    @Override
    public ProdutoDocument process(ProdutoDocument item) throws Exception {
        logger.info("Processando item: {}", item);
        return item;
    }

}