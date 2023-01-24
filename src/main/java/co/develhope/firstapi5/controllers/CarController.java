package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public CarDTO getCar(){
        CarDTO car = new CarDTO();
        car.setId("01");
        car.setModelName("Aston Martin db11");
        car.setPrice(3500.00);
        return car;
    }

    @PostMapping
    public ResponseEntity<String> postCar(@Valid @RequestBody CarDTO car) {
        if (car.getPrice() != 3500.00) {
            return new ResponseEntity<>("Error creating car: invalid price", HttpStatus.BAD_REQUEST);
        }
        System.out.println(car);
        return new ResponseEntity<>("Car created successfully", HttpStatus.CREATED);
    }
}