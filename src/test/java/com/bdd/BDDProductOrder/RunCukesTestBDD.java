package com.bdd.BDDProductOrder;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-report" },
				features = "src/test/resources",
				tags = "@productOrderTest")
public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}
