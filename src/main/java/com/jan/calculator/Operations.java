package com.jan.calculator;

public class Operations {
    
    double first;
    double second;

    public Operations(double first, double second){
        this.first = first;
        this.second = second;
    }

    public double add() {
        return first+second;
    }

    public double subtract() { return first-second; }

    public double multiply() { return first*second; }

    public double divide() { return first/second; }

    public double pwr() {return Math.pow(first, second); }
}
