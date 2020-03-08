package com.poc.split.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.DigestUtils;

@SpringBootApplication
@ConfigurationPropertiesScan
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
