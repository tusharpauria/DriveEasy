package com.driveeasy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Positive
    private BigDecimal pricePerDay;

    private boolean available;
    private boolean deleted = false;

    public Car() {

    }

    public Car(String brand, String model, BigDecimal pricePerDay, boolean available, boolean deleted) {

        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = available;
        this.deleted = deleted;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getBrand() {

        return brand;

    }

    public void setBrand(String brand) {

        this.brand = brand;

    }

    public String getModel() {

        return model;

    }

    public void setModel(String model) {

        this.model = model;

    }

    public BigDecimal getPricePerDay() {

        return pricePerDay;

    }

    public void setPricePerDay(BigDecimal pricePerDay) {

        this.pricePerDay = pricePerDay;

    }

    public boolean isAvailable() {

        return available;

    }

    public void setAvailable(boolean available) {

        this.available = available;

    }

    public boolean isDeleted() {

        return deleted;

    }

    public void setDeleted(boolean deleted) {

        this.deleted = deleted;

    }

    @Override
    public String toString() {

        return "Car {" +
                "id= " + id +
                ", brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", pricePerDay = " + pricePerDay +
                ", available = " + available +
                ", deleted = " + deleted +
                '}';

    }
}
