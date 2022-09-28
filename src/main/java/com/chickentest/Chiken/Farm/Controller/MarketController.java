package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import com.chickentest.Chiken.Farm.Service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketController {
    private final MarketService marketService;


    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/saveMarket")
    @ResponseStatus(HttpStatus.CREATED)
    public Market save(@RequestBody Market market) {return marketService.save(market);}

    @GetMapping("/findMarketById/{id}")
    public Market findById(@PathVariable(value = "id") long id) {return marketService.findById(id);}
}
