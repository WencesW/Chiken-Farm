package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market,Long> {
}
