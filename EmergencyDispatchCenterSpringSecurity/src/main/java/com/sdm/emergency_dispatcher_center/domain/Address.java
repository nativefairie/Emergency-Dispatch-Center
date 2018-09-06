package com.sdm.emergency_dispatcher_center.domain;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    String street;
    String number;
    String country;
    String postalCode;
    String city;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Address(String street, String number, String country, String postalCode, String city, Object o) {
        this.street = street;
        this.number = number;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
