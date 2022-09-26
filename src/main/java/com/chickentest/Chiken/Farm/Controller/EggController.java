package com.chickentest.Chiken.Farm.Controller;

import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import com.chickentest.Chiken.Farm.Service.EggService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class EggController {
    private final EggService eggService;

    EggController(EggService eggService){
        this.eggService = eggService;
    }

    /**
     * Get All eggs
     * @return an Iterable of type Egg
     */
    @GetMapping("/findAllEggs")
    public Iterable<Egg> findAll()
    {
        return eggService.findAll();
    }

    /**
     * Get the egg details by ID
     */
    @GetMapping("/findEggById/{id}")
    public Optional<Egg> findById(@PathVariable(value = "id") long id)

    {
        return eggService.findById(id);
    }

    /**
     * Saves an Object of type Egg on the DB
     */
    @PostMapping("/saveEgg")
    @ResponseStatus(HttpStatus.CREATED)
    public Egg save(@RequestBody Egg egg) {return eggService.save(egg);}

    /**
     * Deletes an Egg from the DB by ID
     */
    @DeleteMapping("/deleteEgg/{id}")
    public void deleteEgg(
            @PathVariable(value = "id") Long id) {eggService.deleteEgg(id);}

    /**
     * Updates an Egg from the DB by its ID
     */
    @PutMapping("/updateEggById/{id}")
    public ResponseEntity<Object> updateEgg(@RequestBody Egg egg, @PathVariable Long id)
    {
        Egg updated = null;
        try {
            updated = eggService.updateEgg(egg,id);

        }
        catch (Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity
                .ok()
                .body(updated);
    }

    @GetMapping("/findEggByFarmId/{id}")
    public List<Egg> findByFarmId(@PathVariable Long id){
        return eggService.findByFarmId(id);
    };

    @GetMapping("/findEggByMarketId/{id}")
    public List<Egg>findByMarketId(@PathVariable Long id){
        return eggService.findByMarketId(id);
    };

}
