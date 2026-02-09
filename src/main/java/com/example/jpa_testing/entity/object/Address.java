package com.example.jpa_testing.entity.object;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
