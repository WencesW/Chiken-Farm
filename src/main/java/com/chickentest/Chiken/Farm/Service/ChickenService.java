package com.chickentest.Chiken.Farm.Service;

import com.chickentest.Chiken.Farm.ChickenNotFoundException;
import com.chickentest.Chiken.Farm.DAO.ChickenRepository;
import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ChickenService {

    private ChickenRepository chickenRepository;

    public ChickenService(ChickenRepository chickenRepository) {
        this.chickenRepository = chickenRepository;
    }

    public List<Chicken> findAll()
    {
        return chickenRepository.findAll();
    }

    public Optional<Chicken> findById(long id)

    {
        return chickenRepository.findById(id);
    }

    public Chicken save(Chicken chicken) {return chickenRepository.save(chicken);}

    public void deleteChicken(Long id) {chickenRepository.deleteById(id);}
    public Chicken updateChicken(Chicken chicken,Long id)
    {

        Optional<Chicken> chickenRepo = chickenRepository.findById(id);

        if (!chickenRepo.isPresent())
            throw new ChickenNotFoundException(id);
        else{
            chicken.setId(id);
            Chicken updated =chickenRepository.save(chicken);
            return updated;
        }
    }

}
