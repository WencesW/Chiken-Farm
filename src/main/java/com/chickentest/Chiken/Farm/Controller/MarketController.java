package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.Models.Market;
import com.chickentest.Chiken.Farm.Service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {
    private final MarketService marketService;


    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/saveMarket")
    @ResponseStatus(HttpStatus.CREATED)
    public Market save(@RequestBody Market market) {return marketService.save(market);}
}
