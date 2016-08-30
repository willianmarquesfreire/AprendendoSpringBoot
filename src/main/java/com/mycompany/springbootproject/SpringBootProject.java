package com.mycompany.springbootproject;

import com.mycompany.springbootproject.config.SecurityConnect;
import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author wmfsystem Parei na aula 2.18
 * Acesse: http://localhost:8080/livros/boleto
 */
@SpringBootApplication
public class SpringBootProject {

//	@Bean
//	public DataSource dataSource(Environment environment) {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
//		dataSource.setUsername("root");
//		dataSource.setPassword("");
//		return dataSource;
//	

    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProject.class, args);
    }

    

}
