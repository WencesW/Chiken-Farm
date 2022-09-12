package com.chickentest.Chiken.Farm;

import com.chickentest.Chiken.Farm.Controller.ChickenController;
import com.chickentest.Chiken.Farm.DAO.ChickenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.Optional;


@SpringBootApplication
public class ChickenFarmApplication {


	private static final Logger log = LoggerFactory.getLogger(ChickenFarmApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ChickenFarmApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ChickenController repository) {
		return (args) -> {
			// save a few customers
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


		};
	}

}
