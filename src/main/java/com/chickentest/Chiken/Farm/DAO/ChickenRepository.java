package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChickenRepository extends JpaRepository<Chicken,Long> {


    List<Chicken>findByFarmId(Long id);

    List<Chicken>findByMarketId(Long id);
}
