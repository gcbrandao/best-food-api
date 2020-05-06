package com.gcbrandao.bestfoodapi;

import com.gcbrandao.bestfoodapi.infrastructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class BestFoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestFoodApiApplication.class, args);
    }

}
