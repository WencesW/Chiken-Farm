package com.chickentest.Chiken.Farm;
import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /*@Bean
    CommandLineRunner initDatabase(ChickenRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Chicken(1)));
            log.info("Preloading " + repository.save(new Chicken(2)));
            log.info("Preloading " + repository.save(new Chicken(45)));
        };
    }*/
}
