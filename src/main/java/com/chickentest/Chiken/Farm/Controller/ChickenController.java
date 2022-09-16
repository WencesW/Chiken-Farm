package com.chickentest.Chiken.Farm.Controller;
import java.util.Optional;
import com.chickentest.Chiken.Farm.DAO.ChickenRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChickenController {
    private final ChickenRepository repository;

    ChickenController(ChickenRepository repository){
        this.repository = repository;
    }

    /**
     * Get All Chickens
     * @return a Iterable of type Chicken
     */
    @GetMapping("/chickens")
    public Iterable<Chicken> findAll()
    {
        return repository.findAll();
    }

    /**
     * Get the chicken details by ID
     */
    @GetMapping("/chicken/{id}")
    public Optional<Chicken> findById(@PathVariable(value = "id") long id)

    {
        return repository.findById(id);
    }

    /**
     * Saves a Object of type Chicken on the DB
     */
    @PostMapping("/saveChicken")
    @ResponseStatus(HttpStatus.CREATED)
    public Chicken save(
            @RequestBody Chicken chicken)
    {
        return repository.save(chicken);
    }

    /**
     * Deletes a Chicken from the DB by ID
     */
    @DeleteMapping("/delete/{id}")
    public void deleteChicken(
            @PathVariable(value = "id") Long id)
    {
        repository.deleteById(id);
    }

    /**
     * Updates a Chicken from the DB by its ID
     */
    @PutMapping("/chickens/{id}")
    public ResponseEntity<Object> updateChicken( @RequestBody Chicken chicken, @PathVariable Long id)
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

    /**
     * Recieves the value of days that the user want to pass and updates the Life Span and Incubation Time of the chickens on the DB.
     */
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
