package com.driveeasy.controller;

import com.driveeasy.Car;
import com.driveeasy.service.CarService;
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
    public Car addCar(@RequestBody Car car) {

        return carService.addCar(car);

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
            @RequestBody Car updatedCar) {

        Optional<Car> car = carService.updateCar(id, updatedCar);

        if (car.isPresent()) return ResponseEntity.ok(car.get());

        else return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {

        boolean deleted = carService.softDeleteCar(id);

        if (deleted) {

            return "Car deleted successfully";

        }

        return "Car not found";

    }

    @GetMapping("/available")
    public List<Car> getAvailableCars() {

        return carService.getAvailableCars();

    }




}
