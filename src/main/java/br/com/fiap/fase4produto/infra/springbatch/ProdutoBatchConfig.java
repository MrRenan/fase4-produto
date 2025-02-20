package br.com.fiap.fase4produto.infra.springbatch;

import br.com.fiap.fase4produto.infra.mongodb.document.produto.ProdutoDocument;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProdutoBatchConfig {

    @Bean
    public Job processarProduto(JobRepository jobRepository, Step step){
        return new JobBuilder("importarProduto", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager platformTransactionManager,
                     ItemReader<ProdutoDocument> itemReader,
                     ItemWriter<ProdutoDocument> itemWriter,
                     ItemProcessor<ProdutoDocument, ProdutoDocument> itemProcessor){
        return new StepBuilder("produtoStep", jobRepository)
                .<ProdutoDocument, ProdutoDocument>chunk(32, platformTransactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }


    @Bean
    public ItemReader<ProdutoDocument> itemReader() {
        return new FlatFileItemReaderBuilder<ProdutoDocument>()
                .name("produtoItemReader")
                .resource(new ClassPathResource("produtos.csv"))
                .linesToSkip(1)
                .lineMapper(new CustomLineMapper())
                .build();
    }

    @Bean
    public ItemWriter<ProdutoDocument> itemWriter(MongoTemplate mongoTemplate){
        CustomMongoItemWriter<ProdutoDocument> itemWriter = new CustomMongoItemWriter<>();
        itemWriter.setTemplate(mongoTemplate);
        itemWriter.setCollection("produto");

        return itemWriter;
    }

    @Bean
    public ItemProcessor<ProdutoDocument, ProdutoDocument> itemProcessor(){
        return new ProdutoProcessor();
    }

}