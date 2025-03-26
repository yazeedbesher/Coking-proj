package com.example.temp.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertArrayEquals;

public class feature2 {
    @Given("the customer is on the custom meal selection page")
    public void theCustomer_selectmeal() {}

    @When("the custoemr selects ingredients from the available list")
    public void the_custoemr_selects_ingredients_from_the_available_list() {}

    @Then("the system should validate the ingredient be valid")
    public void the_system_should_validate_the_ingredient_be_valid() {}

    @Then("the system should allow the customer to procced with the order")
    public void system_allows_order() {}

    @When("the customer selects an unvailable or incompatible ingredient")
    public void the_customer_selects_an_unvailable_or_incompatible_ingredient() {}

    @Then("the system should display an error meassage")
    public void the_system_should_display_an_error_meassage() {}

    @Then("the system should not allow the ccustomer to procced")
    public void system_should_not_allow_customer_to_procced() {}
}
