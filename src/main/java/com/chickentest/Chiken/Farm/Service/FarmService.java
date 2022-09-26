package com.chickentest.Chiken.Farm.Service;

import com.chickentest.Chiken.Farm.ChickenNotFoundException;
import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import com.sun.source.util.SourcePositions;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public int countChickens(){
        int chickensOnFarm = 0;
        for (Chicken chickens : chickenService.findAll()){
            if (chickens.getFarm()!=null){
                chickensOnFarm++;
            }
        }
        return chickensOnFarm;
    }

    private int countChickensMarket() {
        int chickensOnMarket = 0;
        for (Chicken chickens : chickenService.findAll()){
            if (chickens.getMarket()!=null){
                chickensOnMarket++;
            }
        }
        return chickensOnMarket;
    }

    public int countEggs(){
        int eggsOnFarm = 0;
        for (Egg eggs : eggService.findAll()){
            if (eggs.getFarm()!=null){
                eggsOnFarm++;
            }
        }
        return eggsOnFarm;
    }

    private int countEggsMarket() {
        int eggsOnMarket = 0;
        for (Egg eggs : eggService.findAll()){
            if (eggs.getMarket()!=null){
                eggsOnMarket++;
            }
        }
        return eggsOnMarket;
    }

    public Farm pastTime(int days, Farm farm){
        for (Chicken chickens : chickenService.findAll()) {
            if (chickens.getFarm()!=null) {
                chickens.setSpanLife(chickens.getSpanLife() + days);
                chickenService.updateChicken(chickens, chickens.getId());
                if (chickens.getSpanLife() <= 100) {
                    if ((chickens.getIncubationTime()+days)<=25){
                        chickens.setIncubationTime(chickens.getIncubationTime() + days);
                        chickenService.updateChicken(chickens, chickens.getId());
                        }
                    else {
                        chickens.setIncubationTime(0);
                        chickenService.updateChicken(chickens, chickens.getId());
                        if (countEggs()<=15){
                        eggService.save(new Egg(0,farm));
                        }
                        else {
                            farm.setMoney(farm.getMoney() + 20);
                            farm = updateFarm(farm, 1L);
                        }
                    }
                }
                else chickenService.deleteChicken(chickens.getId());
            }
        }
        for (Egg eggs : eggService.findAll()){
            if (eggs.getFarm()!=null){
                eggs.setSpanLife(eggs.getSpanLife()+days);
                eggService.updateEgg(eggs,eggs.getId());
                if (eggs.getSpanLife()>=25){
                    eggService.deleteEgg(eggs.getId());
                    if (countChickens()<=5) {
                        chickenService.save(new Chicken(0, 0, farm));
                    }
                    else {
                        farm.setMoney(farm.getMoney() + 50);
                        farm = updateFarm(farm, 1L);
                    }

                }
            }
        }
        return farm;
    }


    public Farm sellChickens(int units, Farm farm, Market market){
        int counter = 1;
        if (countChickens() >= units){

            for (Chicken chickens: chickenService.findAll()) {
                if (counter>units) return farm;
                {
                    if (chickens.getFarm() != null) {
                        chickens.setFarm(null);
                        chickens.setMarket(market);
                        chickenService.updateChicken(chickens, chickens.getId());
                        farm.setMoney(farm.getMoney() + 50);
                        farm = updateFarm(farm, 1L);
                        counter++;
                    }
                }
            }
        }
        return farm;
    }

    public Farm sellEggs(int units, Farm farm, Market market){
        int counter = 1;
        if (countEggs() >= units){

            for (Egg eggs: eggService.findAll()) {
                if (counter>units) return farm;
                {
                    if (eggs.getFarm() != null) {
                        eggs.setFarm(null);
                        eggs.setMarket(market);
                        eggService.updateEgg(eggs, eggs.getId());
                        farm.setMoney(farm.getMoney() + 20);
                        farm = updateFarm(farm, 1L);
                        counter++;
                    }
                }
            }
        }
        return farm;
    }

    public Farm buyEggs(int units, Farm farm, Market market){
        int counter = 1;
        if ((farm.getMoney()-(units*20))>=0){
            if (countEggsMarket() >= units){
                for (Egg eggs: eggService.findAll()) {
                    if (counter>units) return farm;
                    {
                        if (eggs.getMarket() != null) {
                            eggs.setMarket(null);
                            eggs.setFarm(farm);
                            eggService.updateEgg(eggs, eggs.getId());
                            farm.setMoney(farm.getMoney() - 20);
                            farm = updateFarm(farm, 1L);
                            counter++;
                        }
                    }
                }
            }
        }
        return farm;
    }

    public Farm buyChickens(int units, Farm farm, Market market){
        int counter = 1;
        if ((farm.getMoney()-(units*50))>=0){
            if (countChickensMarket() >= units){
                for (Chicken chickens: chickenService.findAll()) {
                    if (counter>units) return farm;
                    {
                        if (chickens.getMarket() != null) {
                            chickens.setMarket(null);
                            chickens.setFarm(farm);
                            chickenService.updateChicken(chickens, chickens.getId());
                            farm.setMoney(farm.getMoney() - 50);
                            farm = updateFarm(farm, 1L);
                            counter++;
                        }
                    }
                }
            }
        }
        return farm;
    }


    public List<Chicken> findAllTheChickensWithFarmId(Long id){
        return chickenService.findByFarmId(1L);
    }

    public List<Egg> findAllTheEggsWithFarmId(Long id){
        return eggService.findByFarmId(1L);
    }


}
