package com.sony.ifbatch.db2db.job;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.sony.ifbatch.base.job.BaseJob;
import com.sony.ifbatch.sample.entity.SuperModelEntity;
import com.sony.ifbatch.sample.service.DbToDbService;
import com.sony.log.ItemFailureLoggerListener;

@Component
public class DbToDbJob extends BaseJob {
	


	@Bean
	public Job personJob() {//Job name is unique in all
		return jobs.get("personJob").start(dbToDB()).build();
	}	

    @Bean
    public Step dbToDB(){//NG
        return steps
                .get("dbToDB")
                .transactionManager(transactionManager)
                .listener(new ItemFailureLoggerListener())
                .<SuperModelEntity,SuperModelEntity>chunk(2)
                .reader(reader())
                //.processor(processor())
                //.processor(beanValidatingItemProcessor())
                .writer(writer())
                .build();
    }
    
    @Bean
    public Step dbToDBOne(){//OK step name is unique in all
        return steps
                .get("dbToDBOne")
                .transactionManager(transactionManager)
                .listener(new ItemFailureLoggerListener())
                .<SuperModelEntity,SuperModelEntity>chunk(1)
                .reader(oneReader())
                .writer(writer())
                .build();
    }
    

    public MyBatisPagingItemReader<SuperModelEntity> reader() {//NG no recommend usage
    	
    	return new MyBatisPagingItemReaderBuilder<SuperModelEntity>()
    		      .sqlSessionFactory(sqlSessionFactory)
    		      .pageSize(2)
    		      //.parameterValues(parameterValues)
    		      .queryId("com.sony.ifbatch.sample.repository.SuperModelRepository.selectSuperModelAll")
    		      .build();
    }
    
    public MyBatisCursorItemReader<SuperModelEntity> oneReader() {//OK
    	
    	Map<String,Object> parameterValues = new HashMap<>();
    	parameterValues.put("superModelId", "05");
    	parameterValues.put("localeId", "04");
    	
    	return new MyBatisCursorItemReaderBuilder<SuperModelEntity>()    			
    		      .sqlSessionFactory(sqlSessionFactory)
    		      .parameterValues(parameterValues)
    		      .queryId("com.sony.ifbatch.sample.repository.SuperModelRepository.selectSuperModel")
    		      .build();
    }
    
    public MyBatisCursorItemReader<SuperModelEntity> cursorReader() {//OK
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
    

    public MyBatisBatchItemWriter<SuperModelEntity> writer( ){//OK
    	return new MyBatisBatchItemWriterBuilder<SuperModelEntity>()
    		      .sqlSessionFactory(sqlSessionFactory)
    		      .statementId("com.sony.ifbatch.sample.repository.SuperModelRepository.updateSuperModel")
    		      .build();
    }

}
