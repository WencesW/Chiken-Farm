package com.chickentest.Chiken.Farm.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Chicken> chickens = new ArrayList<Chicken>();

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Egg> eggs = new ArrayList<Egg>();

    private int money;

    public Farm() {
    }

    public Farm(ArrayList<Chicken> chickens, ArrayList<Egg> eggs, int money) {
        this.chickens = chickens;
        this.eggs = eggs;
        this.money = money;
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

    public int getMoney() {
        return money;
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

    public void setMoney(int money) {
        this.money = money;
    }
}
