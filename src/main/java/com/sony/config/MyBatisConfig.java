package com.sony.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@AutoConfigureAfter(DBConfig.class)
public class MyBatisConfig {

    @Autowired
    DataSource dataSource;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        try {
            bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}