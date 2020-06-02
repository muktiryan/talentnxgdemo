package com.talentnxg.talentnxgapi.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
		          .driverClassName("org.postgresql.Driver")
		          .url("jdbc:postgresql://35.202.17.127:5432/postgres")
//		          .url("jdbc:postgresql://localhost:5432/tnxg")
		          .username("postgres")
		          .password("p@ssword.1")
//		          .password("postgres")
		          .build(); 
	}
}
