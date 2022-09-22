package com.chickentest.Chiken.Farm;

import com.chickentest.Chiken.Farm.Controller.ChickenController;
import com.chickentest.Chiken.Farm.Controller.EggController;
import com.chickentest.Chiken.Farm.Controller.FarmController;
import com.chickentest.Chiken.Farm.Models.Egg;
import com.chickentest.Chiken.Farm.Models.Farm;
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
	public CommandLineRunner demo(ChickenController chickenController, EggController eggController, FarmController farmController) {
		return (args) -> {

			/*
			// save a few chickens
			repository.save(new Chicken(1,0));
			repository.save(new Chicken(12,0));
			repository.save(new Chicken(11,0));
			repository.save(new Chicken(12,0));
			repository.save(new Chicken(20,0));

			// fetch all chickens
			log.info("Chickens found with findAll():");
			log.info("-------------------------------");
			for (Chicken chicken : repository.findAll()) {
				log.info(chicken.toString());
			}
			log.info("");

			// fetch an individual chicken by ID
			Optional<Chicken> chicken = repository.findById(10L);
			log.info("Chicken found with findById(1L):");
			log.info("--------------------------------");
			log.info(chicken.toString());
			log.info("");


			// delete a chicken by ID
			repository.deleteChicken(2L);

			log.info("Chickens found with findAll() After deleting the Chicken with the Id 2 :");
			log.info("-------------------------------");
			for (Chicken chickens : repository.findAll()) {
				log.info(chickens.toString());
			}
			log.info("");

			repository.pastTime(80);

			log.info("Chickens Life Span and incubation time updated");
			log.info("-------------------------------");
			for (Chicken chickens : repository.findAll()) {
				log.info(chickens.toString());
			}
			log.info("");



			// save a few eggs
			eggrepo.save(new Egg(10,farmrepo.findById(1L)));
			eggrepo.save(new Egg(23,farmrepo.findById(1L)));
			eggrepo.save(new Egg(31,farmrepo.findById(1L)));
			eggrepo.save(new Egg(44,farmrepo.findById(1L)));

			// fetch all eggs
			log.info("Eggs found with findAll():");
			log.info("-------------------------------");
			for (Egg egg : eggrepo.findAll()) {
				log.info(egg.toString());
			}
			log.info("");

			// fetch an individual egg by ID
			Optional<Egg> egg = eggrepo.findById(1L);
			log.info("Egg found with findById(1L):");
			log.info("--------------------------------");
			log.info(egg.toString());
			log.info("");

			// delete a egg by ID
			eggrepo.deleteEgg(2L);

			log.info("Eggs found with findAll() After deleting the Chicken with the Id 2 :");
			log.info("-------------------------------");
			for (Egg eggs : eggrepo.findAll()) {
				log.info(eggs.toString());
			}
			log.info("");


			 */
			List<Chicken> farmChickens = new ArrayList<Chicken>();
			List<Egg> farmEggs = new ArrayList<Egg>();
 			Farm farm=farmController.save(new Farm(farmChickens,farmEggs));
			 chickenController.save(new Chicken(1,1,farm));
			 eggController.save(new Egg(1,farm));





		};



	}


}
