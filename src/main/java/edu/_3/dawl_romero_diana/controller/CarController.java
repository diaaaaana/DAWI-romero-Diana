package edu._3.dawl_romero_diana.controller;

import edu._3.dawl_romero_diana.dto.CarDto;
import edu._3.dawl_romero_diana.response.findAllCarResponse;
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



}
