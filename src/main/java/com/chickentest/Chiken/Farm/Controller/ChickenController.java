package com.chickentest.Chiken.Farm.Controller;
import java.util.List;

import com.chickentest.Chiken.Farm.ChickenNotFoundException;
import com.chickentest.Chiken.Farm.ChickenRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChickenController {
    private final ChickenRepository repository;

    ChickenController(ChickenRepository repository){
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/chickens")
    List<Chicken> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/chickens")
    Chicken newEmployee(@RequestBody Chicken newChicken) {
        return repository.save(newChicken);
    }

    // Single item

    @GetMapping("/chickens/{id}")
    Chicken one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ChickenNotFoundException(id));
    }

    @PutMapping("/chickens/{id}")
    Chicken replaceChicken(@RequestBody Chicken newChicken, @PathVariable Long id) {

        return repository.findById(id)
                .map(chicken -> {
                    chicken.setSpan_life(newChicken.getSpan_life());
                    return repository.save(chicken);
                })
                .orElseGet(() -> {
                    newChicken.setId(id);
                    return repository.save(newChicken);
                });
    }

    @DeleteMapping("/chickens/{id}")
    void deleteChicken(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
