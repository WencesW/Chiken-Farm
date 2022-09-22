package com.chickentest.Chiken.Farm.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "eggs")

public class Egg{
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int spanLife;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = true)
    private Farm farm;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    @Override
    public String toString() {
        return "Egg " +
                "id = " + id +
                "spanLife = " + spanLife
                ;
    }
}
