package com.chickentest.Chiken.Farm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chickentest.Chiken.Farm.Controller.ChickenController;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class ChickenFarmApplication {


	private static final Logger log = LoggerFactory.getLogger(ChickenFarmApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ChickenFarmApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ChickenRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Chicken(1));
			repository.save(new Chicken(12));
			repository.save(new Chicken(11));
			repository.save(new Chicken(12));
			repository.save(new Chicken(20));

			// fetch all chickens
			log.info("Chicken found with findAll():");
			log.info("-------------------------------");
			for (Chicken chicken : repository.findAll()) {
				log.info(chicken.toString());
			}
			log.info("");

			// fetch an individual chicken by ID
			/*Chicken chicken = repository.findById();
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(chicken.toString());
			log.info("");*/

		};
	}


}
