package com.sony.ifbatch.db2csv.job;

import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.sony.ifbatch.base.job.BaseJob;
import com.sony.ifbatch.sample.entity.SuperModelEntity;
import com.sony.log.ItemFailureLoggerListener;

@Component
public class DbToCsvJob extends BaseJob {

	@Bean
	public Job dbToCsvJobBean() {//Job name is unique in all bean
		return jobs.get("dbToCsvJobBean").start(dbToCsvStep()).build();
	}	

    @Bean
    public Step dbToCsvStep(){//NG
        return steps
                .get("dbToCsvStep")
                .transactionManager(transactionManager)
                .listener(new ItemFailureLoggerListener())
                .<SuperModelEntity,SuperModelEntity>chunk(2)
                .reader(reader())
                //.processor(processor())
                //.processor(beanValidatingItemProcessor())
                .writer(writer())
                .build();
    }
    
    public ItemProcessor<? super SuperModelEntity, ? extends SuperModelEntity> processor() {
		
		return null;
	}

	public MyBatisCursorItemReader<SuperModelEntity> reader() { 
    	return new MyBatisCursorItemReaderBuilder<SuperModelEntity>()    			
    		      .sqlSessionFactory(sqlSessionFactory)
    		      .queryId("com.sony.ifbatch.sample.repository.SuperModelRepository.selectSuperModelAll")
    		      .build();
    }
    

    public BeanValidatingItemProcessor<SuperModelEntity> beanValidatingItemProcessor() {
	    BeanValidatingItemProcessor<SuperModelEntity> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
	    beanValidatingItemProcessor.setFilter(true);
	    return beanValidatingItemProcessor;
    }
    

    public FlatFileItemWriter<SuperModelEntity> writer( ){
    	return new FlatFileItemWriterBuilder<SuperModelEntity>()
    		.name("writer_super_model")
    		      .resource(new FileSystemResource("/log/super_model.csv"))
    		      .lineAggregator(new DelimitedLineAggregator<SuperModelEntity>() {{
                      setFieldExtractor(new BeanWrapperFieldExtractor<SuperModelEntity>() {{
                          setNames(new String[]{"localeId", "superModelId","bizID","webPageSunriseDate"});
                      }});
                  }})
    		      .build();
    }
    

    
//    @Bean
//    public ItemReaderAdapter<SuperModelEntity> itemReader() {
//	    ItemReaderAdapter<SuperModelEntity> reader = new ItemReaderAdapter<>();
//	    reader.setTargetObject(dbToDbService);
//	    reader.setTargetMethod("selectSuperModelAll");
//	    return reader;
//    }

}
