package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.DAO.EggRepository;
import com.chickentest.Chiken.Farm.Models.Egg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class EggController {
    private final EggRepository repository;

    EggController(EggRepository repository){
        this.repository = repository;
    }

    /**
     * Get All eggs
     * @return a Iterable of type Egg
     */
    @GetMapping("/eggs")
    public Iterable<Egg> findAll()
    {
        return repository.findAll();
    }

    /**
     * Get the egg details by ID
     */
    @GetMapping("/egg/{id}")
    public Optional<Egg> findById(@PathVariable(value = "id") long id)

    {
        return repository.findById(id);
    }

    /**
     * Saves a Object of type Egg on the DB
     */
    @PostMapping("/saveEgg")
    @ResponseStatus(HttpStatus.CREATED)
    public Egg save(
            @RequestBody Egg egg)
    {
        return repository.save(egg);
    }

    /**
     * Deletes a Egg from the DB by ID
     */
    @DeleteMapping("/delete/{id}")
    public void deleteEgg(
            @PathVariable(value = "id") Long id)
    {
        repository.deleteById(id);
    }

    /**
     * Updates a Egg from the DB by its ID
     */
    @PutMapping("/eggs/{id}")
    public ResponseEntity<Object> updateEgg(@RequestBody Egg egg, @PathVariable Long id)
    {

        Optional<Egg> eggRepo
                = repository.findById(id);

        if (!eggRepo.isPresent())
            return ResponseEntity
                    .notFound()
                    .build();

        egg.setId(id);

        repository.save(egg);

        return ResponseEntity
                .noContent()
                .build();
    }

    /**
     * Recieves the value of days that the user want to pass and updates the Life Span and Incubation Time of the eggs on the DB.
     */
    @GetMapping("/pastTimeEggs/{days}")
    public ResponseEntity<Object> pastTime(@PathVariable(value = "days") int days){
        for (Egg eggs : repository.findAll()) {
            if (eggs.getSpanLife()<100){
                eggs.setSpanLife(eggs.getSpanLife()+days);
            }
            else repository.deleteById(eggs.getId());
        }
        return ResponseEntity
                .noContent()
                .build();
    }
}
