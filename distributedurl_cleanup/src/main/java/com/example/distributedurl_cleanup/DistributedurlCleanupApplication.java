package com.example.distributedurl_cleanup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DistributedurlCleanupApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedurlCleanupApplication.class, args);
    }
}
