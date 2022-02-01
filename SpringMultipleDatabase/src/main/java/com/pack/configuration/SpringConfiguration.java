package com.pack.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class SpringConfiguration {
	
	@Autowired
	Environment env;
	
	@Bean
	@Primary
	public  DataSource  firstDataSource()
	{
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource1.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource1.url"));
		dataSource.setUsername(env.getProperty("spring.datasource1.username"));
		dataSource.setPassword(env.getProperty("spring.datasource1.password"));
		return dataSource;
		
	}
	
	
	
	@Bean
	public  DataSource secondDataSource()
	{
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource2.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource2.url"));
		dataSource.setUsername(env.getProperty("spring.datasource2.username"));
		dataSource.setPassword(env.getProperty("spring.datasource2.password"));
		return dataSource;
		
	}
	
	
	@Bean("jdbc1")
	public JdbcTemplate jdbctemplateOne(@Autowired @Qualifier("firstDataSource") DataSource ds)
	
	{
		
		return new JdbcTemplate(ds);
	}
	
	
	@Bean
	public JdbcTemplate jdbctemplateTwo(@Autowired @Qualifier("secondDataSource")  DataSource ds)
	
	{
		
		return new JdbcTemplate(ds);
	}
	}