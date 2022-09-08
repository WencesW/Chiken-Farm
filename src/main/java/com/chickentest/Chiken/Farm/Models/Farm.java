package com.chickentest.Chiken.Farm.Models;

import java.util.ArrayList;

public class Farm {
    private ArrayList <Chicken> chickens = new ArrayList<Chicken>();
    private ArrayList <Egg> eggs = new ArrayList<Egg>();
    private int money;

    public Farm(ArrayList<Chicken> chickens, ArrayList<Egg> eggs, int money) {
        this.chickens = chickens;
        this.eggs = eggs;
        this.money = money;
    }


}
