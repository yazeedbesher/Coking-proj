package org.example.ahmad_project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="Cases",monochrome=true,snippets = CucumberOptions.SnippetType.CAMELCASE,
glue = {"org/example/ahmad_project"})

public class AcceptanceTest {

}
