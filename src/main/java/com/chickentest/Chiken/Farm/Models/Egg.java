package com.chickentest.Chiken.Farm.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Entity
@Table(name = "eggs")
@Transactional
public class Egg{
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int spanLife;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = true)
    private Farm farm;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id", nullable = true)
    private Market market;

    public Egg() {
    }

    public Egg(int spanLife, Farm farm) {
        this.spanLife = spanLife;
        this.farm = farm;
    }

    public Egg(int spanLife, Market market) {
        this.spanLife = spanLife;
        this.market = market;
    }

    public Long getId() {
        return id;
    }

    public int getSpanLife() {
        return spanLife;
    }

    public Farm getFarm() {
        return farm;
    }

    public Market getMarket() {
        return market;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Egg " +
                "id = " + id +
                "spanLife = " + spanLife
                ;
    }
}
