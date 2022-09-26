package com.chickentest.Chiken.Farm.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = true)
    private Farm farm;

    @JsonBackReference
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

    public Market getMarket() {
        return market;
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

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void setMarket(Market market) {
        this.market = market;
    }



/*    @Override
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

 */
}
