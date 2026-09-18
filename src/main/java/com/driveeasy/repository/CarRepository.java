package com.driveeasy.repository;

import com.driveeasy.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {


        List<Car> findByDeletedFalse();

        Optional<Car> findByIdAndDeletedFalse(Long id);

        List<Car> findByAvailableTrueAndDeletedFalse();

}
