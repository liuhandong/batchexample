package com.sony.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages = {"com.sony"})
@AutoConfigureAfter(DBConfig.class)
public class BatchConfig {
    
	@Bean
	public JobRepository createJobRepository(@Qualifier("dataSource")DataSource dataSource,@Qualifier("transactionManager") PlatformTransactionManager transactionManager) throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(transactionManager);
		//factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
		factory.setTablePrefix("BATCH_");
		factory.setMaxVarCharLength(1000);
		return factory.getObject();
	}
}