package com.jan.calculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.function.BiFunction;

@Component
public class MyCalculatorApplication implements CommandLineRunner {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        double first = 0;
        double second = 0;
        String operator;

        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String ITALIC = "\u001B[3m";

        //Check first number
        System.out.println("Command Line Calculator\nPlease provide a number:");
        while(true){
            try{
                first = scanner.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println(RED + "X " + RESET + "Please enter a valid number " + ITALIC + "(use ',' as comma)");
                scanner.next();
            }
        }

        //Check second number
        System.out.println("Please provide a second number:");
        while(true){
            try{
                second = scanner.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println(RED + "X " + RESET + "Please enter a valid number (use ',' as comma)");
                scanner.next();
            }
        }

        //Check the operator
        System.out.println("What operation should be executed?\n(Available:" + GREEN + " + " + RESET + "," + GREEN + " - "
                + RESET + "," + GREEN + " * " + RESET + "," + GREEN + " / " + RESET + "," + GREEN + " pwr" + RESET +")");
        while(true){
            operator  = scanner.next();
            if (Arrays.asList("+", "-", "*", "/", "pwr").contains(operator)) {
                break;
            }
            System.out.println(RED + "X " + RESET + "Invalid operator, please choose from the list above.");
        }

        //Calculate the results
        Operations calculate = new Operations(first, second);

        HashMap<String, BiFunction<Double, Double, Double>> operationsMap = new HashMap<>();
        operationsMap.put("+", (a, b) -> calculate.add());
        operationsMap.put("-", (a, b) -> calculate.subtract());
        operationsMap.put("*", (a, b) -> calculate.multiply());
        operationsMap.put("/", (a, b) -> calculate.divide());
        operationsMap.put("pwr", (a, b) -> calculate.pwr());
        double result = operationsMap.get(operator).apply(first, second);
        System.out.println("Calculated result:\n" + RED + first + " " + operator + " " + second + " = " + result);

    }
}
