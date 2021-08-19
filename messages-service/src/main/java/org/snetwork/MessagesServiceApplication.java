package org.snetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MessagesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessagesServiceApplication.class, args);
    }
}
