package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

@RunWith(Cucumber.class)
@CucumberOptions(features ="Cases",monochrome=true,snippets = CucumberOptions.SnippetType.CAMELCASE,
glue = {"org.example.ahmad_project.AcceptanceTest"})

public class AcceptanceTest {

}
