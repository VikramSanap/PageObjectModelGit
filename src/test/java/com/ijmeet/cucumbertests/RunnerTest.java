package com.ijmeet.cucumbertests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features = "E:\\eclipse-workspace\\PageObjectModel\\src\\test\\resources\\Features", glue = { "com.testingshastra.stepdefinitions" }, tags = "Regression or Smoke")
	public class RunnerTest extends AbstractTestNGCucumberTests {


}
