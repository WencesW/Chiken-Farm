package com.chickentest.Chiken.Farm.Controller;
import java.util.Optional;

import com.chickentest.Chiken.Farm.DAO.ChickenRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class ChickenController {
    private final ChickenRepository repository;

    ChickenController(ChickenRepository repository){
        this.repository = repository;
    }

    // Get All Chickens
    @GetMapping("/chickens")
    public Iterable<Chicken> findAll()
    {
        return repository.findAll();
    }

    // Get the chicken details by
    // ID

    @GetMapping("/chickens/{id}")
    public Optional<Chicken> findById(@PathVariable(value = "id") long id)

    {
        return repository.findById(id);
    }

    @PostMapping("/chickens")
    @ResponseStatus(HttpStatus.CREATED)
    public Chicken save(
            @RequestBody Chicken chicken)
    {
        return repository.save(chicken);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChicken(
            @PathVariable(value = "id") Long id)
    {
        repository.deleteById(id);
    }

    @PutMapping("/chickens/{id}")
    public ResponseEntity<Object> updateChicken(
            @RequestBody Chicken chicken,
            @PathVariable Long id)
    {

        Optional<Chicken> chickenRepo
                = repository.findById(id);

        if (!chickenRepo.isPresent())
            return ResponseEntity
                    .notFound()
                    .build();

        chicken.setId(id);

        repository.save(chicken);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/pastTimeChickens/{days}")
    public ResponseEntity<Object> pastTime(@PathVariable(value = "days") int days){
        for (Chicken chickens : repository.findAll()) {
            chickens.setSpanLife(chickens.getSpanLife()+days);
            if (chickens.getSpanLife()<100){
                chickens.setIncubationTime(chickens.getIncubationTime()+days);
                updateChicken(chickens,chickens.getId());
            }
            else repository.deleteById(chickens.getId());
        }
        return ResponseEntity
                .noContent()
                .build();
    }
}
