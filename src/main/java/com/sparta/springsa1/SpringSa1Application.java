package com.sparta.springsa1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringSa1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSa1Application.class, args);
    }

}
