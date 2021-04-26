package com.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/",
        glue = {"com.selenium.glue"},
        plugin = {"json:target/report-json/Runner.json", "html:target/Runner"})
public class FeatureRunner extends AbstractTestNGCucumberTests {
}
