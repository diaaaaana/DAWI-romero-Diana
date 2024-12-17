package edu._3.dawl_romero_diana.service;


import edu._3.dawl_romero_diana.dto.CarCreateDto;
import edu._3.dawl_romero_diana.dto.CarDetailDto;
import edu._3.dawl_romero_diana.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> findAllCar() throws Exception;

    Optional<CarDetailDto> findDetailCar(Integer id) throws Exception;

    boolean updateCar(CarDto car) throws Exception;

    boolean createCar(CarCreateDto car) throws Exception;

    boolean deleteCar(Integer id) throws Exception;

}
