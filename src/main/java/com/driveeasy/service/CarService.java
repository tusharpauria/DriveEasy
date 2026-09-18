package com.driveeasy.service;

import com.driveeasy.Car;
import com.driveeasy.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;

    }

    public Car addCar(Car car) {

        return carRepository.save(car);

    }

    public Optional<Car> getCarById(Long id) {

        return carRepository.findByIdAndDeletedFalse(id);

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

    public boolean softDeleteCar(Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {

            Car car = optionalCar.get();

            car.setDeleted(true);

            carRepository.save(car);

            return true;

        }

        return false;

    }

    public List<Car> getAllCars() {

        return carRepository.findByDeletedFalse();

    }

    public List<Car> getAvailableCars() {

        return carRepository.findByAvailableTrueAndDeletedFalse();

    }

    public List<Car> searchByBrand(String brand) {

        return carRepository.findByBrandIgnoreCaseAndDeletedFalse(brand);

    }


}
