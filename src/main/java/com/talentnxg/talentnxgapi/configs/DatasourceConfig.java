package com.talentnxg.talentnxgapi.configs;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
//	jdbc:postgresql:///<DATABASE_NAME>?cloudSqlInstance=<INSTANCE_CONNECTION_NAME>&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=<POSTGRESQL_USER_NAME>&password=<POSTGRESQL_USER_PASSWORD>
//	String googleConnectionName= "jdbc:postgresql://google/postgres?cloudSqlInstance=dotted-hulling-275514:us-central1:cloud-tnxg-postgres&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=postgres&password=p@ssword.1";
	String googleConnectionName= "jdbc:postgresql://google/postgres?cloudSqlInstance=valiant-sandbox-286800:us-central1:cloud-tnxg-postgres&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=postgres&password=p@ssword.1";
<<<<<<< HEAD
//	valiant-sandbox-286800:us-central1:cloud-tnxg-postgres
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
		          .driverClassName("org.postgresql.Driver")
//		          .url(googleConnectionName)
		          .url("jdbc:postgresql://34.121.112.120:5432/postgres")
=======
	
	
	
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
//		          .driverClassName("org.postgresql.Driver")
		          .url(googleConnectionName)
//		          .url("jdbc:postgresql://34.121.112.120:5432/postgres")
>>>>>>> 1e9e39f04af1132d48c0ddb70d0b2cf2a6275cd6
//		          .url("jdbc:postgresql://localhost:5433/postgres")
//		          .url("jdbc:postgresql://localhost:5432/newtnxg")
		          .username("postgres")
		          .password("p@ssword.1")
		          .build(); 
	}
}