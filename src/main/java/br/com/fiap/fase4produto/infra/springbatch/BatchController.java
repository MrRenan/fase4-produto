package br.com.fiap.fase4produto.infra.springbatch;

import br.com.fiap.fase4produto.infra.restapi.v1.BatchApi;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController implements BatchApi {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Override
    public String executarSpringBatch() throws Exception{

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
        return "Job executado com sucesso!";
    }
}