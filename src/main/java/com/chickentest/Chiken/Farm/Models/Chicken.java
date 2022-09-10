package com.chickentest.Chiken.Farm.Models;

import javax.persistence.*;

@Entity
@Table(name = "chickens")

public class Chicken {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int span_life;
    private int incuvation_time;

    protected Chicken() {}

    public Chicken( int span_life, int incuvation_time) {
        this.span_life = span_life;
        this.incuvation_time = incuvation_time;
    }

    public Long getId() {
        return id;
    }

    public int getSpan_life() {
        return span_life;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpan_life(int span_life) {
        this.span_life = span_life;
    }

    @Override
    public String toString() {
        return "Chicken { " +
                "Id = " + id +
                " , span life = " + span_life +
                " , incuvation time = " + incuvation_time +
                " } ";
    }
}
