package edu._3.dawl_romero_diana.service.impl;

import edu._3.dawl_romero_diana.dto.CarCreateDto;
import edu._3.dawl_romero_diana.dto.CarDetailDto;
import edu._3.dawl_romero_diana.dto.CarDto;
import edu._3.dawl_romero_diana.entity.Car;
import edu._3.dawl_romero_diana.repository.CarRepository;
import edu._3.dawl_romero_diana.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> findAllCar() throws Exception {
        List<CarDto> lista = new ArrayList<>();
            Iterable<Car> iterable=carRepository.findAll();
            iterable.forEach(car ->{
                lista.add(new CarDto(
                        car.getCarId(),
                        car.getMake(),
                        car.getLicensePlate(),
                        car.getOwnerName(),
                        car.getColor()
                ));
            });
            return lista;
    }

    @Override
    public Optional<CarDetailDto> findDetailCar(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car->new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getPurchaseDate(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getServiceDueDate()
                ));
    }

    @Override
    public boolean updateCar(CarDto car) throws Exception {
        Optional<Car> optional = carRepository.findById(car.carId());
        return optional.map(ca -> {
            ca.setMake(car.make());
            ca.setLicensePlate(car.licensePlate());
            ca.setOwnerName(car.ownerName());
            ca.setColor(car.color());
            return true;
        }).orElse(false);
    }

    @Override
    public boolean createCar(CarCreateDto carDto) throws Exception {
        Car car = new Car();
        car.setMake(carDto.make());
        car.setModel(carDto.model());
        car.setYear(carDto.year());
        car.setVin(carDto.vin());
        car.setLicensePlate(carDto.licensePlate());
        car.setOwnerContact(carDto.ownerContact());
        car.setMileage(carDto.mileage());
        car.setEngineType(carDto.engineType());
        car.setColor(carDto.color());
        car.setInsuranceCompany(carDto.insuranceCompany());
        return true;
    }

    @Override
    public boolean deleteCar(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car ->{
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }
}
