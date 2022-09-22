package com.chickentest.Chiken.Farm.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "markets")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Chicken> chickens = new ArrayList<Chicken>();

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Egg> eggs = new ArrayList<Egg>();

    public Market() {
    }

    public Market(List<Chicken> chickens, List<Egg> eggs) {
        this.chickens = chickens;
        this.eggs = eggs;
    }

    public Long getId() {
        return id;
    }

    public List<Chicken> getChickens() {
        return chickens;
    }

    public List<Egg> getEggs() {
        return eggs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChickens(List<Chicken> chickens) {
        this.chickens = chickens;
    }

    public void setEggs(List<Egg> eggs) {
        this.eggs = eggs;
    }
}
