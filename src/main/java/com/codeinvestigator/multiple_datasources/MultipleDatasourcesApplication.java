package com.codeinvestigator.multiple_datasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MultipleDatasourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatasourcesApplication.class, args);
    }

}
