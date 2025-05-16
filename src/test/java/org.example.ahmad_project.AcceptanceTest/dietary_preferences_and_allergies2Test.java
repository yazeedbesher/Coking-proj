package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import com.example.cooking_proj.dietary_preferences_and_allergies;

public class dietary_preferences_and_allergies2Test {
    dietary_preferences_and_allergies PreAndAlle = new dietary_preferences_and_allergies();

//1

    @When("the chef wants to view empty customer dietary preferences list")
    public void theChefWantsToViewEmptyCustomerDietaryPreferencesList() {
       Assert.assertEquals(List(),PreAndAlle.getPreferences());
    }

//2
@When("the chef wants to view customer dietary preferences")
public void theChefWantsToViewCustomerDietaryPreferences() {

}


//3


    @When("the chef wants to view empty customer dietary allergies list")
    public void theChefWantsToViewEmptyCustomerDietaryAllergiesList() {


    }
//4
    @When("the chef wants to view customer dietary allergies")
    public void theChefWantsToViewCustomerDietaryAllergies() {

    }





    @Then("the system will pop up an error message")
    public void theSystemWillPopUpAnErrorMessage() {

    }
    @Then("the system will return false")
    public void theSystemWillReturnFalse() {

    }

    @Then("the system will return empty lists")
    public void theSystemWillReturnEmptyLists() {




    }


    @Then("the system will pop up a success message")
    public void theSystemWillPopUpASuccessMessage() {

    }
    @Then("the system will return true")
    public void theSystemWillReturnTrue() {

    }

    @Then("the system will return the preferences list")
    public void theSystemWillReturnThePreferencesList() {

    }
    @Then("the system will return an empty allergies list")
    public void theSystemWillReturnAnEmptyAllergiesList() {

    }



    @Then("the system will return the preferences and allergies lists")
    public void theSystemWillReturnThePreferencesAndAllergiesLists() {

    }


    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }
}
