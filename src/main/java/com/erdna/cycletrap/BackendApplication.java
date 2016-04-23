package com.erdna.cycletrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by André Nitzschke on 23/04/16.
 */
@SpringBootApplication
public class BackendApplication {

    private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class);
    }

    @Bean
    public CommandLineRunner demo(TrapRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Trap("Schlagloch"));
            repository.save(new Trap("Fahrradweg zu Ende"));
            repository.save(new Trap("Scherben"));

            // fetch all customers
            log.info("Traps found with findAll():");
            log.info("-------------------------------");
            for (Trap trap : repository.findAll()) {
                log.info(trap.toString());
            }
            log.info("");

            // fetch an individual trap by ID
            Trap trap = repository.findOne(1L);
            log.info("Trap found with findOne(1L):");
            log.info("--------------------------------");
            log.info(trap.toString());
            log.info("");

            // fetch customers by last name
            log.info("Trap found with findByName('Schlagloch'):");
            log.info("--------------------------------------------");
            for (Trap bauer : repository.findByName("Schlagloch")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
}
