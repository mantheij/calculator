package com.jan.calculator;

public class Operations {
    
    int first;
    int second;

    public Operations(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int add() {
        return first+second;
    }
}
