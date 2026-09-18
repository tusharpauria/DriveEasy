package com.driveeasy.service;

import com.driveeasy.Car;
import com.driveeasy.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;

    }

    public Car addCar(Car car) {

        return carRepository.save(car);

    }

    public List<Car> getAllCars() {

        return carRepository.findAll();

    }

    public Optional<Car> getCarById(Long id) {

        return carRepository.findById(id);

    }

    public Optional<Car> updateCar(Long id, Car updatedCar) {

        Optional<Car> existingCar = carRepository.findById(id);

        if (existingCar.isPresent()) {

            Car car = existingCar.get();

            car.setBrand(updatedCar.getBrand());
            car.setModel(updatedCar.getModel());
            car.setPricePerDay(updatedCar.getPricePerDay());
            car.setAvailable(updatedCar.isAvailable());

            return Optional.of(carRepository.save(car));

        }

        return Optional.empty();

    }

    public  void deleteCar(Long id) {

        carRepository.deleteById(id);

    }


}
