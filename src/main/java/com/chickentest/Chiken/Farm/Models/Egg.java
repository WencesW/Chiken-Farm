package com.chickentest.Chiken.Farm.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Egg {
    private @Id @GeneratedValue Long id;
    private int span_life;

    public Egg(int span_life) {
        this.span_life = span_life;
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
        return "Egg " +
                "id = " + id +
                "span_life = " + span_life
                ;
    }
}
