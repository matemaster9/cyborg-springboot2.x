package org.mastercs.cyborg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author: cyborg
 * Create: 2023/5/18 10:26
 */
@EnableScheduling
@SpringBootApplication
public class Springboot2xApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot2xApplication.class, args);
    }
}
