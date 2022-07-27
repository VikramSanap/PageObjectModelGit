package com.ijmeet.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParameterizationStepDefinitions {
	int x, y, result;
	String string, string2, string3, string4;
	List<Integer> numbers;
	DataTable dataTable;
	Map<String, List> map;

	@Given("I have {int} and {int}")
	public void i_have_and(Integer int1, Integer int2) {
		x = int1;
		y = int2;
	}

	@When("I add those numbers")
	public void i_add_those_numbers() {
		result = x + y;
	}

	@Then("print the result")
	public void print_the_result() {
		System.out.println("Result is :" + result);
	}

	@Given("I have {string} and {string}")
	public void i_have_and(String string, String string2) {
		this.string = string;
		this.string2 = string2;

	}

	@Then("Arrange them in an alphabetical order")
	public void arrange_them_in_an_alphabetical_order() {
		if (string.compareTo(string2) == 0) {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings are identical");
			System.out.println(
					"**********************************************************************************************");
		} else if (string.compareTo(string2) > 0) {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings in an alphabetical order :" + string2 + "\t" + string);
			System.out.println(
					"**********************************************************************************************");
		} else {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings in an alphabetical order :" + string + "\t" + string2);
			System.out.println(
					"**********************************************************************************************");
		}

	}

	@Given("I have {word} and {word} two words")
	public void i_have_tow_words(String string3, String string4) {
		this.string3 = string3;
		this.string4 = string4;

	}

	@Then("I arrange them in an alphabetical order")
	public void I_arrange_them_in_an_alphabetical_order() {
		if (string3.compareTo(string4) == 0) {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings are identical");
			System.out.println(
					"**********************************************************************************************");
		} else if (string3.compareTo(string4) > 0) {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings in an alphabetical order :" + string4 + "\t" + string3);
			System.out.println(
					"**********************************************************************************************");
		} else {
			System.out.println(
					"**********************************************************************************************");
			System.out.println("Strings in an alphabetical order :" + string3 + "\t" + string4);
			System.out.println(
					"**********************************************************************************************");
		}

	}

	@When("I have followig numbers:")
	public void i_have_followig_numbers(io.cucumber.datatable.DataTable dataTable) {
		numbers = dataTable.asList(Integer.class);
	}

	@Then("Print all numbers from list")
	public void print_all_numbers_from_list() {
		System.out.println("**********************the list of numbers is*******************");
		for (Integer integer : numbers)
			System.out.println("\t\t\t\t" + integer);

	}

	@Given("I have following table:")
	public void i_have_following_table(DataTable dataTable) {
		this.dataTable= dataTable;
		map = dataTable.asMap(String.class, List.class);
		
		
	}

	@Then("Print the Table")
	public void print_the_table() {
		System.out.println("*******************************************************************");
		System.out.println(dataTable);
		System.out.println("*******************************************************************");
		System.out.println("Map Representation of Data Table :"+map);
		System.out.println("*******************************************************************");

	}

}
