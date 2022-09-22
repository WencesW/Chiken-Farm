package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Service.FarmService;
import org.springframework.http.HttpStatus;
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

}
