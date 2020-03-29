package com.lojacarro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.lojacarro.demo.model"})
@EnableJpaRepositories(basePackages = {
        "com.lojacarro.demo.repository"
        })
public class LojaCarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaCarroApplication.class, args);
	}

}
