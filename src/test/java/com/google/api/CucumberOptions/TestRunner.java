package com.google.api.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/google/api/features",
		glue="com.google.api.steps",
		//tags= "@GoogleDeletePlaceAPI",
				plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html"})

	//	stepNotifications = true)

public class TestRunner {

}
