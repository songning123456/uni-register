package com.uni.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author songning
 */
@SpringBootApplication
@EnableEurekaServer
public class UniRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniRegisterApplication.class, args);
    }

}
