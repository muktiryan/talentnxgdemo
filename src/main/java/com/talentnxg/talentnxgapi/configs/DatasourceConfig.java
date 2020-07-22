package com.talentnxg.talentnxgapi.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
//	jdbc:postgresql:///<DATABASE_NAME>?cloudSqlInstance=<INSTANCE_CONNECTION_NAME>&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=<POSTGRESQL_USER_NAME>&password=<POSTGRESQL_USER_PASSWORD>
	String googleConnectionName= "jdbc:postgresql://google/postgres?cloudSqlInstance=dotted-hulling-275514:us-central1:cloud-tnxg-postgres&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=postgres&password=p@ssword.1";
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
		          .driverClassName("org.postgresql.Driver")
		          .url(googleConnectionName)
//		          .url("jdbc:postgresql://35.202.17.127:5432/postgres")
//		          .url("jdbc:postgresql://localhost:5433/postgres")
		          .username("postgres")
		          .password("p@ssword.1")
		          .build(); 
	}
}