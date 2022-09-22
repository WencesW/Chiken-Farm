package com.chickentest.Chiken.Farm.Service;


import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.DAO.MarketRepository;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketService {

    private MarketRepository marketRepository;
    private FarmService farmService;
    private ChickenService chickenService;
    private EggService eggService;

    public MarketService(MarketRepository marketRepository, FarmService farmService, ChickenService chickenService, EggService eggService) {
        this.marketRepository = marketRepository;
        this.farmService = farmService;
        this.chickenService = chickenService;
        this.eggService = eggService;
    }

    public Market save(Market market){return marketRepository.save(market);}

    public Optional<Market> findById(long id)

    {
        return marketRepository.findById(id);
    }


}
