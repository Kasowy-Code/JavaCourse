package com.example.demo;

public class MessagePrinter {
    private final SimpleMessageProducer messageProducer = new SimpleMessageProducer();

    public void printMessage() {
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
