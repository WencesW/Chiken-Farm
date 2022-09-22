package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Service.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FarmController {
    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/saveFarm")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm farm) {return farmService.save(farm);}

    @GetMapping("/findFarmById/{id}")
    public Optional<Farm> findById(@PathVariable(value = "id") long id) {return farmService.findById(id);}

    @GetMapping("/pastTimeFarm/{days}")
    public ResponseEntity<Object> pastTime(@PathVariable(value = "days") int days,@RequestBody Farm farm){
        Farm timePast = null;
            timePast= farmService.pastTime(days,farm);
        return ResponseEntity
                .ok()
                .body(timePast);
    }

    @GetMapping("/sellChickens/{units}")
    public ResponseEntity<Object> sellChickens(@PathVariable(value = "units") int units,@RequestBody Farm farm){
        Farm chickenSells = null;
        chickenSells= farmService.sellChickens(units,farm);
        return ResponseEntity
                .ok()
                .body(chickenSells);
    }



}
