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


}
