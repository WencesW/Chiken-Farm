package com.chickentest.Chiken.Farm.Controller;
import java.util.List;
import java.util.Optional;
import com.chickentest.Chiken.Farm.DAO.ChickenRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Service.ChickenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChickenController {
    private final ChickenService chickenService;

    ChickenController(ChickenService chickenService){
        this.chickenService = chickenService;
    }

    /**
     * Get All Chickens
     * @return a Iterable of type Chicken
     */
    @GetMapping("/findAllChickens")
    public List<Chicken> findAll()
    {
        return chickenService.findAll();
    }

    /**
     * Get the chicken details by ID
     */
    @GetMapping("/findChickenById/{id}")
    public Optional<Chicken> findById(@PathVariable(value = "id") long id)

    {
        return chickenService.findById(id);
    }

    /**
     * Saves a Object of type Chicken on the DB
     */
    @PostMapping("/saveChicken")
    @ResponseStatus(HttpStatus.CREATED)
    public Chicken save(@RequestBody Chicken chicken) {return chickenService.save(chicken);}

    /**
     * Deletes a Chicken from the DB by ID
     */
    @DeleteMapping("/deleteChicken/{id}")
    public void deleteChicken(@PathVariable(value = "id") Long id) {chickenService.deleteChicken(id);}

    /**
     * Updates a Chicken from the DB by its ID
     */
    @PutMapping("/updateChickenById/{id}")
    public ResponseEntity<Object> updateChicken( @RequestBody Chicken chicken, @PathVariable Long id)
    {
        Chicken updated = null;
        try {
            updated = chickenService.updateChicken(chicken,id);

        }
        catch (Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity
                .ok()
                .body(updated);
    }

    @GetMapping("/findChickenByFarmId/{id}")
    public String findByFarmId(@PathVariable Long id, Model model){
        model.addAttribute("chickensOnFarm",chickenService.findByFarmId(id));
        return "index";
    };

    @GetMapping("/findChickenByMarketId/{id}")
    public List<Chicken>findByMarketId(@PathVariable Long id){

        return chickenService.findByMarketId(id);
    };



}
