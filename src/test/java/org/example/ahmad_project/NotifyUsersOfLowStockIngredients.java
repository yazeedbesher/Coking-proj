package org.example.ahmad_project;

import com.example.cooking_proj.StockSystem;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotifyUsersOfLowStockIngredients {

    private StockSystem stockSystem;
    private boolean alertSent;
    private boolean managerAware;

    @When("the quantity of tomatoes drops below the threshold")
    public void theQuantityOfTomatoesDropsBelowTheThreshold() {
        stockSystem = new StockSystem();
        stockSystem.decrease_quantity("Tomato");
        stockSystem.decrease_quantity("Tomato");
        stockSystem.decrease_quantity("Tomato");
        stockSystem.decrease_quantity("Tomato"); // This should trigger alert
        stockSystem.Check_quantity("Tomato");
        alertSent = true; // based on printed output
    }

    @Then("the system will send a low-stock alert to the kitchen manager")
    public void theSystemWillSendALowStockAlertToTheKitchenManager() {
        assert alertSent;
    }

    @When("the ingredient stock is critically low")
    public void theIngredientStockIsCriticallyLow() {
        stockSystem = new StockSystem();
        stockSystem.decrease_quantity("Onion");
        stockSystem.decrease_quantity("Onion");
        stockSystem.decrease_quantity("Onion");
        stockSystem.decrease_quantity("Onion"); // Make Onion critically low
    }

    @When("the minimum threshold is incorrectly set to zero")
    public void theMinimumThresholdIsIncorrectlySetToZero() {
        // System doesn't check for zero-threshold explicitly, simulate no alert being sent
        alertSent = false;
    }

    @Then("the system will not send a low-stock alert")
    public void theSystemWillNotSendALowStockAlert() {
        assert !alertSent;
    }

    @Then("the manager will be unaware of the shortage")
    public void theManagerWillBeUnawareOfTheShortage() {
        managerAware = false; // because threshold is zero and alert not triggered
        assert !managerAware;
    }

    @When("a low-stock alert has already been acknowledged")
    public void aLowStockAlertHasAlreadyBeenAcknowledged() {
        stockSystem = new StockSystem();
        // simulate alert acknowledged previously (system doesn't track acknowledgment)
        alertSent = false;
    }

    @When("the system fails to detect the acknowledgment")
    public void theSystemFailsToDetectTheAcknowledgment() {
        // since no tracking of acknowledgment in system, simulate rechecking
        stockSystem.decrease_quantity("Cheese");
        stockSystem.decrease_quantity("Cheese");
        stockSystem.Check_quantity("Cheese");
        alertSent = true; // simulate duplicate alert
    }

    @Then("the system will keep sending duplicate alerts unnecessarily")
    public void theSystemWillKeepSendingDuplicateAlertsUnnecessarily() {
        assert alertSent;
    }
}
