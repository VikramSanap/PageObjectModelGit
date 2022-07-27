package com.ijmeet.stepdefinitions;

import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepDefinition {
	int firstNumber, secondNumber, result;

	@Given("Take two numbers as input")
	public void take_two_numbers_as_input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		firstNumber = sc.nextInt();
		System.out.println("Enter second number");
		secondNumber = sc.nextInt();
	}

	@When("I add them")
	public void i_add_them() {
		result = firstNumber + secondNumber;
	}

	@Then("Verify if addition is a prime number or not")
	public void verify_if_addition_is_a_prime_number_or_not() {
		int count = 0;
		for (int i = 1; i < result; i++) {
			if (result % i == 0) {
				count++;
			}
		}
		if (count > 2) {
			System.out.println("Result is not a prime number");
		} else
			System.out.println("Result is a prime number");
	}

}
