package com.chickentest.Chiken.Farm;

public class ChickenNotFoundException  extends RuntimeException{
    ChickenNotFoundException(Long id){
        super("Could not find the chicken" + id);
    }
}
