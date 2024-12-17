package edu._3.dawl_romero_diana.controller;

import edu._3.dawl_romero_diana.dto.CarCreateDto;
import edu._3.dawl_romero_diana.dto.CarDetailDto;
import edu._3.dawl_romero_diana.dto.CarDto;
import edu._3.dawl_romero_diana.response.*;
import edu._3.dawl_romero_diana.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public findAllCarResponse findAllCar(){
        try {
            List<CarDto> list=carService.findAllCar();
            if(!list.isEmpty()){
                return new findAllCarResponse("01",null,list);
            }else
                return new findAllCarResponse("02","Cars not fount",null);
        }catch(Exception e){
            e.printStackTrace();
            return new findAllCarResponse("99","An error ocurred, please tray again.",null);
        }
    }

    @GetMapping("/detail")
    public findCarDetailResponse findCarDetail(@RequestParam(value = "id", defaultValue = "0") String id){
        try {
            Optional<CarDetailDto> optional = carService.findDetailCar(Integer.parseInt(id));
            return optional.map(car->
                    new findCarDetailResponse("01",null,car)
            ).orElse(
                    new findCarDetailResponse("02","car not found",null)
            );
        }catch (Exception e){
            e.printStackTrace();
            return new findCarDetailResponse("99","An error ocurred, please try again.",null);
        }
    }

    @PostMapping("/create")
    public createCarResponse createCar(@RequestBody CarCreateDto car){
        try {
            if(carService.createCar(car))
                return   new createCarResponse("01",null);
            else
                return    new createCarResponse("02","create failed");
        }catch (Exception e){
            e.printStackTrace();
            return new createCarResponse("99","An error ocurred, please try again.");
        }
    }

    @PutMapping("/update")
    public updateCarResponse updateCar(@RequestBody CarDto car){
        try{
            boolean c =carService.updateCar(car);
            if(c)
                return new updateCarResponse("01",null);
            else
                return new updateCarResponse("02","update failed.");
        }catch (Exception e){
            e.getStackTrace();
            return new updateCarResponse("99","An error ocurred, please try again.");
        }
    }

    @DeleteMapping("delete/{id}")
    public deleteCarResponse deleteCar(@PathVariable Integer id){
        try {
            if(carService.deleteCar(id))
                return new deleteCarResponse("01",null);
            else
                return new deleteCarResponse("02","failed delete");
        }catch (Exception e){
            e.getStackTrace();
            return new deleteCarResponse("99","An error ocurred, please try again.");
        }
    }

}
