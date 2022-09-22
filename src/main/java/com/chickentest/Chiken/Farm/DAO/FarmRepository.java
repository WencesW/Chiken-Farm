package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm,Long> {
}
