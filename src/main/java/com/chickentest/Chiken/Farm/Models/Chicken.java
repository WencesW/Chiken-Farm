package com.chickentest.Chiken.Farm.Models;

import javax.persistence.*;

@Entity
@Table(name = "chickens")

public class Chicken {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int spanLife;
    private int incubationTime;

    protected Chicken() {}

    public Chicken(int spanLife, int incubationTime) {
        this.spanLife = spanLife;
        this.incubationTime = incubationTime;
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
