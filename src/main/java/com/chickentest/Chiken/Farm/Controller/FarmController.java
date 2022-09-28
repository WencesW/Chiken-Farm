package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import com.chickentest.Chiken.Farm.Service.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FarmController {
    private final FarmService farmService;

    private final MarketController marketController;

    public FarmController(FarmService farmService, MarketController marketController) {
        this.farmService = farmService;
        this.marketController = marketController;
    }

    @PostMapping("/saveFarm")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm farm) {return farmService.save(farm);}

    @GetMapping("/findFarmById/{id}")
    public Farm findById(@PathVariable(value = "id") long id) {return farmService.findById(id);}

    @GetMapping("/pastTimeFarm/{days}")
    public String pastTime(@RequestParam(value = "days") int days){
        Farm timePast = null;
            timePast= farmService.pastTime(days,farmService.findById(1L));
        return "redirect:/";
    }

    @GetMapping("/sellChickens/{unitsOfChickensToSell}")
    public String sellChickens(@PathVariable(value = "unitsOfChickensToSell") int units){
        Farm chickenSells = null;
        chickenSells= farmService.sellChickens(units, farmService.findById(1L), farmService.findMarketById(1L));
        return "redirect:/";
    }

    @GetMapping("/sellEggs/{unitsOfEggsToSell}")
    public String sellEggs(@PathVariable(value = "unitsOfEggsToSell") int units){
        Farm eggSells = null;
        eggSells= farmService.sellEggs(units, farmService.findById(1L), farmService.findMarketById(1L));
        return "redirect:/";
    }

    @GetMapping("/BuyEggs/{unitsOfEggsToBuy}")
    public String buyEggs(@RequestParam(value = "unitsOfEggsToBuy") int units){
        Farm eggBuy = null;
        eggBuy= farmService.buyEggs(units, farmService.findById(1L), farmService.findMarketById(1L));
        return "redirect:/";
    }

    @GetMapping("/BuyChickens/{unitsOfChickensToBuy}")
    public String buyChickens(@RequestParam(value = "unitsOfChickensToBuy") int units) {
        Farm chickenBuy = null;
        chickenBuy = farmService.buyChickens(units, farmService.findById(1L), farmService.findMarketById(1L));
        return "redirect:/";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("chickens", farmService.findAllTheChickensWithFarmId(1L));
        model.addAttribute("eggs", farmService.findAllTheEggsWithFarmId(1L));
        model.addAttribute("Farm",farmService.findById(1L));
        return "index";
    }


}
