package com.chickentest.Chiken.Farm.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "chickens")
@Transactional
public class Chicken {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int spanLife;
    private int incubationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = true)
    private Farm farm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id", nullable = true)
    private Market market;

    public Chicken() {
    }

    public Chicken(int spanLife, int incubationTime, Farm farm) {
        this.spanLife = spanLife;
        this.incubationTime = incubationTime;
        this.farm = farm;
    }

    public Chicken(int spanLife, int incubationTime, Market market) {
        this.spanLife = spanLife;
        this.incubationTime = incubationTime;
        this.market = market;
    }

    public Long getId() {
        return id;
    }

    public int getSpanLife() {
        return spanLife;
    }

    public int getIncubationTime() {
        return incubationTime;
    }

    public Farm getFarm() {
        return farm;
    }

    public Long getFarmId(){return farm.getId();}

    public Market getMarket() {
        return market;
    }

    public Long getMarketId(){return market.getId();}
    public void setId(Long id) {
        this.id = id;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    public void setIncubationTime(int incubationTime) {
        this.incubationTime = incubationTime;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
    public void setFarmId(Long id) { this.farm.setId(id);}

    public void setMarketId(Long id){ this.market.setId(id);}


    @Override
    public String toString() {
        if(farm != null) {
            return "Chicken{" +
                    "id=" + id +
                    ", spanLife=" + spanLife +
                    ", incubationTime=" + incubationTime +
                    ", farm=" + farm.getId() +
                    '}';
        }
        else
            return "Chicken{" +
                "id=" + id +
                ", spanLife=" + spanLife +
                ", incubationTime=" + incubationTime +
                ", market=" + market.getId() +
                '}';
}
}
