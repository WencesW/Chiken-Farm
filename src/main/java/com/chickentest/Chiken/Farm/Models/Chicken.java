package com.chickentest.Chiken.Farm.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "chickens")
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    public void setIncubationTime(int incubationTime) {
        this.incubationTime = incubationTime;
    }

    @Override
    public String toString() {
        return "Chicken { " +
                "Id = " + id +
                " , span life = " + spanLife +
                " , incuvation time = " + incubationTime +
                " } ";
    }
}
