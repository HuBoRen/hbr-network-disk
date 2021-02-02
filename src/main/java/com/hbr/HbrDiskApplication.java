package com.hbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HbrDiskApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbrDiskApplication.class, args);
    }

}
