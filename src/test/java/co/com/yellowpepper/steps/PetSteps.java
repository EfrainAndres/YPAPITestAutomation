package co.com.yellowpepper.steps;

import co.com.yellowpepper.config.BaseTest;
import co.com.yellowpepper.utils.PayloadUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetSteps extends BaseTest {

    private Response response;

    @Given("I create a pet with ID {int} and name {string}")
    public void iCreateAPetWithIdAndName(int id, String name) {
        String payload = PayloadUtils.getPayload("pet.json", "createPet");
        response = request.body(payload).post("/pet");
    }

    @When("I get the pet by ID {int}")
    public void iGetThePetById(int id) {
        response = request.get("/pet/" + id);
    }

    @Then("the pet name should be {string}")
    public void thePetNameShouldBe(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(expectedName, actualName);
    }

    @When("I update the pet with ID {int} to name {string}")
    public void iUpdateThePetWithIdToName(int id, String newName) {
        String payload = PayloadUtils.getPayload("pet.json", "updatePet");
        response = request.body(payload).put("/pet");
    }

    @When("I delete the pet with ID {int}")
    public void iDeleteThePetWithId(int id) {
        response = request.delete("/pet/" + id);
    }

    @Then("the pet with ID {int} should not exist")
    public void thePetWithIdShouldNotExist(int id) {
        response = request.get("/pet/" + id);
        Assert.assertEquals(404, response.getStatusCode());
    }
}
