package com.chickentest.Chiken.Farm.DAO;

import com.chickentest.Chiken.Farm.Models.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {
}
