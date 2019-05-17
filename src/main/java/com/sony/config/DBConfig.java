package com.sony.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value={"classpath:application.properties"})
public class DBConfig {	
	
	private final Logger logger = LoggerFactory.getLogger(DBConfig.class);
    
	@Value("${spring.datasource.url}")
    public String url;
	@Value("${spring.datasource.driver-class-name}")
    public String jdbcname;
	@Value("${spring.datasource.username}")
    public String user;
	@Value("${spring.datasource.password}")
    public String password;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.mybatis-config}")
    private String mybatisConfig;	
    
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcname);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = null;
        try {
            DataSource dataSource = (DataSource)dataSource();
            sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(mapperLocations));
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfig));
        } catch (Exception e) {
        	logger.error("创建SqlSession连接工厂错误：{}",e);
        }
        return sqlSessionFactoryBean;
    }
 
}