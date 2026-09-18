package com.driveeasy.controller;

import com.driveeasy.Car;
import com.driveeasy.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {

        this.carService = carService;

    }

    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {

        Car savedCar = carService.addCar(car);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCar);

    }

    @GetMapping
    public List<Car> getAllCars() {

        return carService.getAllCars();
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {

        Optional<Car> car = carService.getCarById(id);

        if (car.isPresent()) return ResponseEntity.ok(car.get());

        else return ResponseEntity.notFound().build();


    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(
            @PathVariable Long id,
           @Valid @RequestBody Car updatedCar) {

        Optional<Car> car = carService.updateCar(id, updatedCar);

        if (car.isPresent()) return ResponseEntity.ok(car.get());

        else return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {

        boolean deleted = carService.softDeleteCar(id);

        if (deleted) {

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/available")
    public List<Car> getAvailableCars() {

        return carService.getAvailableCars();

    }

    @GetMapping("/search")
    public List<Car> searchByBrand(@RequestParam String brand) {

        return carService.searchByBrand(brand);

    }


}
