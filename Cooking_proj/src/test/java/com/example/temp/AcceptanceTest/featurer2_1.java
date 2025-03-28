package com.example.temp.AcceptanceTest;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class featurer2_1 {

   //  boolean ingredientUnavailable;
   //  boolean dietaryConflict;
   // boolean substitutionSuggested;
    //boolean chefAlerted;

    @Given("the customer selects an ingredient that is unavailable")
    public void  customer_selects_unavailable_ingredient() {}

    @When("the system setects the unvailable ingredient")
    public void  unvailable_ingredient() {}

    @Then("the system suggests an alternative ingredient")
    public void  alternative_ingredient() {}

    @And("the system alerts the chef  for approval")
    public void  alerts_the_chef_for_approval() {}

    @Given("the customer selects an ingredients that does not fit their dietary restrictions")
    public void  customer_selects_no_dietary_restrictions() {}

    @When ("the system detects the dietary restriction conflict")
    public void  alerts_the_dietary_restriction_conflict() {}


    @Then ("the system suggest a suitable alternative ingredient")
    public void  suitable_alternative_ingredient() {}
}
