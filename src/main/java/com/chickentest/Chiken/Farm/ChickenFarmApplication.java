package com.chickentest.Chiken.Farm;

import com.chickentest.Chiken.Farm.Controller.ChickenController;
import com.chickentest.Chiken.Farm.Controller.EggController;
import com.chickentest.Chiken.Farm.Controller.FarmController;
import com.chickentest.Chiken.Farm.Controller.MarketController;
import com.chickentest.Chiken.Farm.Models.Egg;
import com.chickentest.Chiken.Farm.Models.Farm;
import com.chickentest.Chiken.Farm.Models.Market;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class ChickenFarmApplication {


	private static final Logger log = LoggerFactory.getLogger(ChickenFarmApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ChickenFarmApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ChickenController chickenController, EggController eggController, FarmController farmController, MarketController marketController) {
		return (args) -> {

			List<Chicken> farmChickens = new ArrayList<Chicken>();
			List<Egg> farmEggs = new ArrayList<Egg>();
			List<Chicken> marketChickens = new ArrayList<Chicken>();
			List<Egg> marketEggs = new ArrayList<Egg>();
 			Farm farm=farmController.save(new Farm((ArrayList<Chicken>) farmChickens, (ArrayList<Egg>) farmEggs,100));
			Market market = marketController.save(new Market(marketChickens,marketEggs));
			 chickenController.save(new Chicken(80,16,farm));
			 chickenController.save(new Chicken(60,16,farm));
			 eggController.save(new Egg(16,farm));

			 farmController.pastTime(21,farm);

			 farmController.sellChickens(1,farm,market);

			 farmController.pastTime(10,farm);

			 eggController.save(new Egg(1,farm));

			 farmController.sellEggs(1,farm,market);

			 farmController.buyEggs(1,farm,market);

			 farmController.buyChickens(1,farm,market);


		};



	}


}
