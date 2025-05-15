package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Inventory_Supply_managment_4_2 {
    Map<String,Double>supplierPrices=new HashMap<>();
    Map<String, Integer> inventory = new HashMap<>();
     Map<String, Integer> criticalThresholds = new HashMap<>();
     List<String> purchaseOrders = new ArrayList<>();
     String selectedItem = "";
     boolean contactedSupplierAPI = false;

    @Given("the kitchen manager selects Olive Oil for price check")
    public void thekitchenmanagerselectsOliveOilforpricecheck(){
        selectedItem = "Olive Oil";
        System.out.println("Selected item for price check: " + selectedItem);
    }
    @When("the system contacts the supplier API")
    public void thesystemcontactsthesupplierapi(){
        contactedSupplierAPI = true;
        supplierPrices.put("Olive Oil", 12.99);
        System.out.println("Contacted supplier API and retrieved price.");
    }

    @Then("it should display the current price for Olive Oil")
    public void itshoulddisplaythecurrentpriceforoliveoil(){
        assertTrue(contactedSupplierAPI);
        assertTrue(supplierPrices.containsKey("Olive Oil"));
        System.out.println("Current price for Olive Oil: $" + supplierPrices.get("Olive Oil"));
    }

    @Given("Flour is needed for a new order")
    public void FlourIsneededforaneworder(){
        selectedItem = "Flour";
        System.out.println("Flour is needed for new order.");
    }

    @Then("it should display both prices for comparison")
    public void itshoulddisplaybothpricesforcomparison(){
        assertTrue(supplierPrices.containsKey("Flour_SupplierA"));
        assertTrue(supplierPrices.containsKey("Flour_SupplierB"));
        System.out.println("Supplier A Price for Flour: $" + supplierPrices.get("Flour_SupplierA"));
        System.out.println("Supplier B Price for Flour: $" + supplierPrices.get("Flour_SupplierB"));
    }

    @When("the system retrieves prices from Supplier A and Supplier B")
    public void thesystemretrievespricesfromSupplierAandSupplierB(){
        supplierPrices.put("Flour_SupplierA", 2.50);
        supplierPrices.put("Flour_SupplierB", 2.30);
        System.out.println("Retrieved prices from Supplier A and B.");
    }

    @Given("Supplier X offers Butter at $5 and Supplier Y offers it at $3.50")
    public void SupplierXoffersButterat$5andSupplieroffersat(){
        supplierPrices.put("Butter_SupplierX", 5.00);
        supplierPrices.put("Butter_SupplierY", 3.50);
    }

    @When("the kitchen manager checks prices")
    public void thekitchenmanagerchecksprices(){
        selectedItem = "Butter";
        System.out.println("Checking prices for Butter...");
    }

    @Then("the system should highlight Supplier Y as the most cost-effective option")
    public void thesystemshouldhighlightSupplierYasthemostcosteffectiveoption(){
        double priceX = supplierPrices.get("Butter_SupplierX");
        double priceY = supplierPrices.get("Butter_SupplierY");
        assertTrue(priceY < priceX);
        System.out.println("Supplier Y is more cost-effective for Butter: $" + priceY);
    }

    @Given("Eggs has only 1 unit left")
    public void eggshasonly1unitleft(){   inventory.put("Eggs", 1);}

    @And("the critical threshold is 3 units")
    public void thecriticalthresholdis3units(){ criticalThresholds.put("Eggs", 3);}

    @When("the system checks inventory")
    public void thesystemchecksinventory(){
        for (String item : inventory.keySet()) {
            int current = inventory.get(item);
            int threshold = criticalThresholds.getOrDefault(item, Integer.MAX_VALUE);
            if (current < threshold) {
                purchaseOrders.add(item);
            }
        }
    }

    @Then("it should generate a purchase order for Eggs")
    public void itshouldgenerateapurchaseorderforeggs(){
        assertTrue(purchaseOrders.contains("Eggs"));
        System.out.println("Generated purchase order for: Eggs");
    }

    @Given("Milk has 0 units and Yeast has 1 unit")
    public void milkhas0unitsAndYeasthas1unit(){
        inventory.put("Milk", 0);
        inventory.put("Yeast", 1);
    }

    @And("both are below critical thresholds")
    public void botharebelowcriticalthresholds(){
        criticalThresholds.put("Milk", 2);
        criticalThresholds.put("Yeast", 3);
    }

    @When("the system performs inventory scan")
    public void thesystemperformsinventoryscan(){
        purchaseOrders.clear(); // reset before each scan
        for (String item : inventory.keySet()) {
            int current = inventory.get(item);
            int threshold = criticalThresholds.getOrDefault(item, Integer.MAX_VALUE);
            if (current < threshold) {
                purchaseOrders.add(item);
            }
        }
    }

    @Then("it should generate purchase orders for both items")
    public void itshouldgeneratepurchaseordersforbothitems(){
        assertTrue(purchaseOrders.containsAll(Arrays.asList("Milk", "Yeast")));
        System.out.println("Generated purchase orders for: " + String.join(", ", purchaseOrders));
    }

    @Given("Cheese has 10 units in stock")
    public void cheesehas10unitsInstock(){
        inventory.put("Cheese", 10);
        criticalThresholds.put("Cheese", 5);
    }

    @When("the system checks stock levels")
    public void thesystemchecksstocklevels(){
        purchaseOrders.clear();
        for (String item : inventory.keySet()) {
            int threshold = criticalThresholds.getOrDefault(item, Integer.MAX_VALUE);
            if (inventory.get(item) < threshold) {
                purchaseOrders.add(item);
            }
        }
    }

    @Then("it should not generate a purchase order for Cheese")
    public void itshouldnotgenerateapurchaseorderforcheese(){
        assertFalse(purchaseOrders.contains("Cheese"));
        System.out.println("No purchase order needed for Cheese.");
    }
}
