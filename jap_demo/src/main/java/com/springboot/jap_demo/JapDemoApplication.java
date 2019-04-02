package com.springboot.jap_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.springboot.jap_demo.*")
@EnableScheduling
public class JapDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JapDemoApplication.class, args);
    }

}
