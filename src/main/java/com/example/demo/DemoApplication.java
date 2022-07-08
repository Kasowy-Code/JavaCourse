package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);
       MessageController messageController = context.getBean(MessageController.class);
       messageController.mainLoop();
    }
    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }
}
