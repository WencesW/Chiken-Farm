package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EggRepository extends JpaRepository<Egg,Long> {
}