package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        MessageProducer messageProducer = new SimpleMessageProducer();
        MessagePrinter firstMessagePrinter = new MessagePrinter(messageProducer);
        MessagePrinter secondMessagePrinter = new MessagePrinter(messageProducer);
        firstMessagePrinter.printMessage();
        secondMessagePrinter.printMessage();
    }
}
