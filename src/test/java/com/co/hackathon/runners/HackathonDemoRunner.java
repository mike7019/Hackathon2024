package com.co.hackathon.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/hackathonDemo.feature",
        glue = "com.co.hackathon.stepdefinitions",
        tags = "@RegisterUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class HackathonDemoRunner {

}
