package com.hanhae99.personalstudy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Personalstudy1Application {

    public static void main(String[] args) {
        SpringApplication.run(Personalstudy1Application.class, args);
    }

}
