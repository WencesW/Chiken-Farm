package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Chicken;
import com.chickentest.Chiken.Farm.Models.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EggRepository extends JpaRepository<Egg,Long> {

    List<Egg>findByFarmId(Long id);

    List<Egg>findByMarketId(Long id);
}
