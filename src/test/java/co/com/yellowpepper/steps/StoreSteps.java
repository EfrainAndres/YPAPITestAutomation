package co.com.yellowpepper.steps;

import co.com.yellowpepper.config.BaseTest;
import co.com.yellowpepper.utils.PayloadUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class StoreSteps extends BaseTest {
    private Response response;

    @Given("I place an order with ID {int} for pet ID {int} with status {string}")
    public void iPlaceAnOrderWithIdForPetIdWithStatus(int orderId, int petId, String status) {
        String payload = PayloadUtils.getPayload("store.json", "placeOrder");
        response = request.body(payload).post("/store/order");
    }

    @When("I get the order by ID {int}")
    public void iGetTheOrderById(int orderId) {
        response = request.get("/store/order/" + orderId);
    }

    @Then("the order status should be {string}")
    public void theOrderStatusShouldBe(String expectedStatus) {
        String actualStatus = response.jsonPath().getString("status");
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @When("I get the store inventory")
    public void iGetTheStoreInventory() {
        response = request.get("/store/inventory");
    }

    @Then("the response should contain inventory details")
    public void theResponseShouldContainInventoryDetails() {
        Assert.assertNotNull(response.jsonPath().getMap(""));
    }

    @When("I delete the order with ID {int}")
    public void iDeleteTheOrderWithId(int orderId) {
        response = request.delete("/store/order/" + orderId);
    }

    @Then("the order with ID {int} should not exist")
    public void theOrderWithIdShouldNotExist(int orderId) {
        response = request.get("/store/order/" + orderId);
        Assert.assertEquals(404, response.getStatusCode());
    }
}