package com.chickentest.Chiken.Farm;

import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChickenRepository extends JpaRepository<Chicken,Long> {
    long count();

}
