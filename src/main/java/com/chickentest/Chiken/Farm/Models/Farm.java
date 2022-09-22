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


    public Farm(List<Chicken> farmChickens, List<Egg> farmEggs) {}

    public Farm(ArrayList<Chicken> chickens, ArrayList<Egg> eggs, int money) {
        this.chickens = chickens;
        this.eggs = eggs;
        this.money = money;
    }


}
