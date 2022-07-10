package com.example.bikerent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bike {
    @Id
    private Long id;
    private String model;
    private String serialNo;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;

    public Bike() {}
}
