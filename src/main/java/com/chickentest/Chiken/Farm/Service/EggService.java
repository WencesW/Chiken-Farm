package com.chickentest.Chiken.Farm.Service;

import com.chickentest.Chiken.Farm.ChickenNotFoundException;
import com.chickentest.Chiken.Farm.DAO.EggRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EggService {
    private EggRepository eggRepository;

    public EggService(EggRepository eggRepository) {this.eggRepository = eggRepository;}

    public List<Egg> findAll()
    {
        return eggRepository.findAll();
    }

    public Optional<Egg> findById(long id)

    {
        return eggRepository.findById(id);
    }

    public Egg save(Egg egg) {return eggRepository.save(egg);}

    public void deleteEgg(Long id) {eggRepository.deleteById(id);}
    public Egg updateEgg(Egg egg,Long id)
    {

        Optional<Egg> eggRepo = eggRepository.findById(id);

        if (!eggRepo.isPresent())
            throw new ChickenNotFoundException(id);
        else{
            egg.setId(id);
            Egg updated =eggRepository.save(egg);
            return updated;
        }
    }

    public List<Egg>findByFarmId(Long id){
        return eggRepository.findByFarmId(id);
    }

    public List<Egg>findByMarketId(Long id){
        return eggRepository.findByMarketId(id);
    }
}
