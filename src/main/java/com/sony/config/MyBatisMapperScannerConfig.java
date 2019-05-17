package com.sony.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	    return new SqlSessionTemplate(sqlSessionFactory);   // 不使用批处理 SqlSession, 推荐用这种方式
	    //return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH); // 使用批处理 SqlSession, 不推荐用这种方式, 如果主键自增, 批处理方式无法获取到自增的id
	}
	
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.sony.ifbatch.*.repository");
        //mapperScannerConfigurer.sqlSessionTemplateBeanName("sqlSessionTemplate");
        mapperScannerConfigurer.setAnnotationClass(org.springframework.stereotype.Repository.class);
        return mapperScannerConfigurer;
    }
}