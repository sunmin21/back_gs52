package com.gs52.main;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.stereotype.Repository;






@EntityScan(basePackages = {"com.gs52.jwt.models"})
@EnableJpaRepositories(basePackages = {"com.gs52.jwt.repository"})
@ComponentScan({
	"com.gs52.jwt.repository",
	"com.gs52.controller",
	"com.gs52.dao",
	
	"com.gs52.jwt.security",	
	
	
})

@SpringBootApplication
public class Gs52Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Gs52Application.class, args);
		System.out.println("시작");
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] arrResource = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml");
		//mapper폴더위치인식
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		return sqlSessionFactoryBean.getObject();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Gs52Application.class);
	}
}
