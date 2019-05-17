package com.sony.ifbatch.base.job;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;


@Component
public class BaseJob {
	
	@Autowired
	public JobBuilderFactory jobs;

	@Autowired
	public StepBuilderFactory steps;
	
	@Autowired
	public PlatformTransactionManager transactionManager;

	@Autowired
	public SqlSessionFactory sqlSessionFactory;
	
    @Autowired
    public DataSource dataSource;	

}
