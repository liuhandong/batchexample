package com.sony.ifbatch.db2csv.job;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.sony.ifbatch.adapter.ServiceAdapterReader;
import com.sony.ifbatch.adapter.ServiceAdapterWriter;
import com.sony.ifbatch.base.job.BaseJob;
import com.sony.ifbatch.builder.ServiceAdapterReaderBuilder;
import com.sony.ifbatch.builder.ServiceAdapterWriterBuilder;
import com.sony.ifbatch.sample.entity.SuperModelEntity;
import com.sony.ifbatch.sample.job.Person;
import com.sony.ifbatch.sample.service.DbToDbService;
import com.sony.log.ItemFailureLoggerListener;

@Component
public class DbToCsvJob extends BaseJob {
	
	@Autowired
	DbToDbService dbToDbService;
	

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
                .reader(serviceReader())
                //.processor(processor())
                //.processor(beanValidatingItemProcessor())
                .writer(serviceWriter())
                .build();
    }
    
    public ServiceAdapterReader<SuperModelEntity> serviceReader() {    	
    	return new ServiceAdapterReaderBuilder<SuperModelEntity>().list(dbToDbService.selectSuperModelAll()).build();
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
    
    public ServiceAdapterWriter<SuperModelEntity,SuperModelEntity> serviceWriter() {
    	
    	return new ServiceAdapterWriterBuilder<SuperModelEntity,SuperModelEntity>()
    			.serviceIds("com.sony.ifbatch.sample.service.DbToDbService.updateSuperModel")//mutil ids
    			.entity(new SuperModelEntity(), "com.sony.ifbatch.sample.service.DbToDbService.updateSuperModel")//desc object
	            .builder();
    }

}
