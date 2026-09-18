package com.driveeasy;

import com.driveeasy.repository.CarRepository;
import com.driveeasy.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void shouldReturnFalseWhenDeletingNonExistingCar() {

        when(carRepository.findById(999L))
                .thenReturn(Optional.empty());

        boolean result = carService.softDeleteCar(999L);

        assertFalse(result);

        verify(carRepository, never()).save(any());

    }
}