package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        NewBikeDTO bike1 = new NewBikeDTO(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        bikeService.add(bike1);
        double payment = bikeService.rentForHours(1L, 5, "ABC987");
        System.out.println("Należność do zapłaty za wypożyczenie: " + payment);
        bikeService.returnBike(1L);
    }
}
