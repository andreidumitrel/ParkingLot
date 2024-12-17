package com.parking.parkinglot1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CarPhoto {
    @Id
    @GeneratedValue
    private Long id;

    String filename;

    String fileType;

    byte[] fileContent;

    @OneToOne
    Car car;

}
