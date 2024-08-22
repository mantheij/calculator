package com.jan.calculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import java.util.Arrays;
import com.jan.calculator.Operations;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}

@Component
class MyCalculatorApplication implements CommandLineRunner {

	Scanner scanner = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command Line Calculator\nPlease provide a number:");
		int first = scanner.nextInt();
		System.out.println("Please provide a second number:");
		int second = scanner.nextInt();
		System.out.println("What operation should be executed?\n(Available: +,-,*,/,sqrt)");
		
		String operator;
		while(true){
			operator  = scanner.next();
			if (Arrays.asList("+", "-", "*", "/", "sqrt").contains(operator)) {
				break;
			}
			System.out.println("Invalid operator, please choose from the list above.");
		}
		
		//Calculate the results
		Operations calculate = new Operations(first, second);
		System.out.println("Calculated result:");
		if(operator.equals("+")){
			System.out.println(calculate.add());
		}
	}
}