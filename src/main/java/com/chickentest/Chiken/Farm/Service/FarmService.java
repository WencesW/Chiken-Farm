package com.chickentest.Chiken.Farm.Service;

import com.chickentest.Chiken.Farm.DAO.FarmRepository;
import com.chickentest.Chiken.Farm.Models.Farm;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmService {
    private FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {this.farmRepository = farmRepository;}

    public Farm save(Farm farm){return farmRepository.save(farm);}

    public Optional<Farm> findById(long id)

    {
        return farmRepository.findById(id);
    }




}
