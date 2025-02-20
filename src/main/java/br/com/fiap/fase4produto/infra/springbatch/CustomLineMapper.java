package br.com.fiap.fase4produto.infra.springbatch;

import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineMapper;

import java.math.BigDecimal;

public class CustomLineMapper implements LineMapper<ProdutoDocument> {

    private static final Logger logger = LoggerFactory.getLogger(CustomLineMapper.class);

    @Override
    public ProdutoDocument mapLine(String line, int lineNumber) throws Exception {
        String[] fields = line.split(",");

        if (fields.length != 5) {
            throw new IllegalArgumentException("Linha " + lineNumber + " do CSV está mal formatada. Esperados 5 campos, mas encontrados " + fields.length);
        }

        logger.info("Lendo linha {}: nomeProduto={}, descricao={}, categoria={}, preco={}, quantidade={}",
                lineNumber, fields[0], fields[1], fields[2], fields[3], fields[4]);

        ProdutoDocument produtoDocument = new ProdutoDocument(
                null,
                fields[0].trim(),
                fields[1].trim(),
                fields[2].trim(),
                new BigDecimal(fields[3].trim()),
                Integer.parseInt(fields[4].trim())
        );
        return produtoDocument;
    }
}