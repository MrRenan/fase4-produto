package br.com.fiap.fase4produto.infra.springbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.data.MongoItemWriter;

public class CustomMongoItemWriter<T> extends MongoItemWriter<T> {

    private static final Logger logger = LoggerFactory.getLogger(CustomMongoItemWriter.class);

    @Override
    public void write(Chunk<? extends T> chunk) throws Exception {
        logger.info("Gravando {} itens no MongoDB", chunk.size());
        super.write(chunk);
    }
}