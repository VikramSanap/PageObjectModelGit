Feature: This feature discribes the parameterization in Cucumber 

@Regression
Scenario: Passing single numeric parameter to Gherkin step 
	Given I have 5 and 6 
	When I add those numbers 
	Then print the result 
@Smoke	
Scenario: Passing string parameter to Gherkin step 
	Given I have "India hello" and "China hi" 
	Then Arrange them in an alphabetical order 
@Sanity
Scenario: Passing word parameter to Gherkin step 
	Given I have "India" and "China" two words 
	Then I arrange them in an alphabetical order 
@Regression @Smoke	
Scenario: Passing list of parameters to Gherkin step
	When I have followig numbers:
	|10|
	|20|
	|30|
	|40|
	|50|
	Then Print all numbers from list
@Smoke @Sanity
Scenario: Passing table of parameters to Gherkin step
	Given I have following table:
	|First Row|10|20|30|40|50|60|70|80|
	|Second Row|80|70|60|50|40|30|20|10|
	Then Print the Table	