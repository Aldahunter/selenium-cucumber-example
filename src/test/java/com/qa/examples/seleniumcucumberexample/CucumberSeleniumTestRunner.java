package com.qa.examples.seleniumcucumberexample;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/" },
				tags = "@selenium",
				snippets = SnippetType.CAMELCASE,
				plugin = { "html:target/cucumber-reports/selenium-cucumber-example-report.html" },
				monochrome = true)
public class CucumberSeleniumTestRunner {
}
