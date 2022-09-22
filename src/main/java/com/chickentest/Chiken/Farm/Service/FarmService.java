package com.chickentest.Chiken.Farm.Service;

import com.chickentest.Chiken.Farm.ChickenNotFoundException;
import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmService {
    private FarmRepository farmRepository;
    private ChickenService chickenService;
    private EggService eggService;

    public FarmService(FarmRepository farmRepository, ChickenService chickenService, EggService eggService) {
        this.farmRepository = farmRepository;
        this.chickenService = chickenService;
        this.eggService = eggService;
    }

    public Farm save(Farm farm){return farmRepository.save(farm);}

    public Optional<Farm> findById(long id)

    {
        return farmRepository.findById(id);
    }

    public Farm updateFarm(Farm farm,Long id)
    {
        Optional<Farm> farmRepo = farmRepository.findById(id);
        farm.setId(id);
        Farm updated =farmRepository.save(farm);
        return updated;
    }

    public Farm pastTime(int days, Farm farm){
        for (Chicken chickens : chickenService.findAll()) {
            if (chickens.getFarmId()==1L) {
                chickens.setSpanLife(chickens.getSpanLife() + days);
                if (chickens.getSpanLife() <= 100) {
                    if ((chickens.getIncubationTime()+days)<=25){
                        chickens.setIncubationTime(chickens.getIncubationTime() + days);
                        chickenService.updateChicken(chickens, chickens.getId());}
                    else {
                        chickens.setIncubationTime(0);
                        if (farm.getEggs().stream().count()<=30){
                        eggService.save(new Egg(0,farm));}
                        else farm.setMoney(farm.getMoney()+20);
                    }
                } else chickenService.deleteChicken(chickens.getId());
            }
        }
        for (Egg eggs : eggService.findAll()){
            if (eggs.getFarmId()==1L){
                eggs.setSpanLife(eggs.getSpanLife()+days);
                if (eggs.getSpanLife()>=25){
                    eggService.deleteEgg(eggs.getId());
                    if (farm.getChickens().stream().count()<=30) {
                        chickenService.save(new Chicken(0, 0, farm));
                    }
                    else  farm.setMoney(farm.getMoney()+50);
                }
            }
        }
        return farm;
    }


    public Farm sellChickens(int units, Farm farm){
        int counter = 0;
        if (farm.getChickens().stream().count() >= units){
            for (Chicken chickens: ChickenService.findAll()) {
                while (counter <= units){
                    if (chickens.getFarmId()==1L) {
                        chickens.setFarmId(null);
                        chickens.setMarketId(1L);
                        chickenService.updateChicken(chickens, chickens.getId());
                        farm.setMoney(farm.getMoney()+50);
                        farm=updateFarm(farm,farm.getId());
                        counter = counter + 1;
                    }
                }
            }
        }
        return farm;
    }




}
