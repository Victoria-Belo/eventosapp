package com.eventosapp.eventosapp;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class DataConfiguration {
	 /*static final String URL = "jdbc:mysql://localhost:3306/eventos_bd?serverTimezone=UTC"; //indica o caminho do banco de dados
	 static final String USER = "root"; // aqui vai o nome usuario que vc quer acessar
	 static final String PASS = "root"; // aqui a senha do seu banco
	 
	 @Bean
	 public DataSource dataSource() {
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  dataSource.setUrl(URL);
		  dataSource.setUsername(USER);
		  dataSource.setPassword(PASS);
		  return dataSource;
	 }
	 
	 @Bean
	 public JpaVendorAdapter jpaaVendorAdapter() {
		  HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		  adapter.setDatabase(Database.MYSQL);
		  adapter.setShowSql(true);
		  adapter.setGenerateDdl(true);
		  adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		  adapter.setPrepareConnection(true);
		  return adapter; 
	 }*/
	 @Bean
	    public BasicDataSource dataSource() throws URISyntaxException {
	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
	    }
}

