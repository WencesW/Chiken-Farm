package com.chickentest.Chiken.Farm.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "farms")
@Transactional
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "farm",fetch = FetchType.LAZY)
    private List<Chicken> chickens = new ArrayList<Chicken>();

    private int sizeOfChickenList;
    @JsonManagedReference
    @OneToMany(mappedBy = "farm",fetch = FetchType.LAZY)
    private List<Egg> eggs = new ArrayList<Egg>();

    private int sizeOfEggList;

    private int money;

    public Farm() {
    }

    public Farm(List<Chicken> chickens, int sizeOfChickenList, List<Egg> eggs, int sizeOfEggList, int money) {
        this.chickens = chickens;
        this.sizeOfChickenList = sizeOfChickenList;
        this.eggs = eggs;
        this.sizeOfEggList = sizeOfEggList;
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

    public int getSizeOfChickenList() {
        return sizeOfChickenList;
    }

    public int getSizeOfEggList() {
        return sizeOfEggList;
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

    public void setSizeOfChickenList(int sizeOfChickenList) {
        this.sizeOfChickenList = sizeOfChickenList;
    }

    public void setSizeOfEggList(int sizeOfEggList) {
        this.sizeOfEggList = sizeOfEggList;
    }
}
