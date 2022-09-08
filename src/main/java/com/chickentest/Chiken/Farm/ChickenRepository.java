package com.chickentest.Chiken.Farm;

import com.chickentest.Chiken.Farm.Models.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChickenRepository extends JpaRepository<Chicken,Long> {

    List<Chicken> findById(long id);

}
