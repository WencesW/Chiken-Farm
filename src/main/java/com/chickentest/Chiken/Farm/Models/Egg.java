package com.chickentest.Chiken.Farm.Models;

import javax.persistence.*;

@Entity
@Table(name = "eggs")

public class Egg {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int spanLife;

    public Egg() {}

    public Egg(int spanLife) {
        this.spanLife = spanLife;
    }

    public Long getId() {
        return id;
    }

    public int getSpanLife() {
        return spanLife;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    @Override
    public String toString() {
        return "Egg " +
                "id = " + id +
                "spanLife = " + spanLife
                ;
    }
}
