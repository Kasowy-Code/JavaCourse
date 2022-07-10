package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeRepository bikeRepository = context.getBean(BikeRepository.class);
        Bike bike1 = new Bike(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        bikeRepository.save(bike1);
        System.out.println("Zapisano bike1 w bazie");

        Bike bike2 = new Bike(2L, "Trek Marlin 7, 26 cali damski", "TMAR98765", 25, 80);
        bikeRepository.save(bike2);
        System.out.println("Zapisano bike2 w bazie");

        System.out.println("Pobieram i wyświetlam bike2:");
        bikeRepository.findById(2L).ifPresent(System.out::println);

        System.out.println("Usuwam bike1 z bazy");
        bikeRepository.deleteById(1L);

        System.out.println("Pobieram i wyświetlam bike1");
        bikeRepository.findById(1L).ifPresentOrElse(System.out::println, () -> System.out.println("Brak roweru z id 1"));

    }
}
