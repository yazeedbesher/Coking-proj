package org.example.ahmad_project;

import com.example.cooking_proj.StockSystem;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifyUsersOfLowStockIngredients {

    private List<Map<String, Integer>> quantities = new ArrayList<Map<String, Integer>>();
    private StockSystem stockSystem = new StockSystem();

    private boolean alertSent;
    private boolean managerAware;

    @When("the quantity of tomatoes drops below the threshold")
    public void theQuantityOfTomatoesDropsBelowTheThreshold() {
//        quantities.put("tomatoes", 5);
//        thresholds.put("tomatoes", 10);
//        alertSent = stockSystem.checkAndSendAlert("tomatoes");
    }

    @Then("the system will send a low-stock alert to the kitchen manager")
    public void theSystemWillSendALowStockAlertToTheKitchenManager() {
        assert alertSent;
//        System.out.println(stockSystem.generateLowStockAlertMessage("tomatoes", "Chef Ahmad"));
    }

    @When("the ingredient stock is critically low")
//    public void theIngredientStockIsCriticallyLow() {
//        quantities.put("onions", 1);
//    }

    @When("the minimum threshold is incorrectly set to zero")
    public void theMinimumThresholdIsIncorrectlySetToZero() {
//        thresholds.put("onions", 0);
//        alertSent = stockSystem.checkAndSendAlert("onions");
    }

    @Then("the system will not send a low-stock alert")
    public void theSystemWillNotSendALowStockAlert() {
        assert !alertSent;
    }

    @Then("the manager will be unaware of the shortage")
    public void theManagerWillBeUnawareOfTheShortage() {
//        managerAware = stockSystem.isManagerAware("onions");
//        assert !managerAware;
    }

    @When("a low-stock alert has already been acknowledged")
//    public void aLowStockAlertHasAlreadyBeenAcknowledged() {
//        stockSystem.acknowledgeAlert("cheese");
//    }

    @When("the system fails to detect the acknowledgment")
    public void theSystemFailsToDetectTheAcknowledgment() {
//        quantities.put("cheese", 2);
//        thresholds.put("cheese", 5);
//        alertSent = stockSystem.checkAndSendAlert("cheese");
    }

    @Then("the system will keep sending duplicate alerts unnecessarily")
    public void theSystemWillKeepSendingDuplicateAlertsUnnecessarily() {
//        assert alertSent && stockSystem.isDuplicateAlert("cheese");
    }
}
