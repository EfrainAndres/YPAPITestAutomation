package co.com.yellowpepper.steps;

import co.com.yellowpepper.config.BaseTest;
import co.com.yellowpepper.utils.PayloadUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class UserSteps extends BaseTest {

    private Response response;
    private String currentUsername;

    @Given("I create a user with username {string} and ID {int}")
    public void iCreateAUserWithUsernameAndId(String username, int userId) {
        currentUsername = username;
        String payload = PayloadUtils.getPayload("user.json", "createUser");
        JSONObject json = new JSONObject(payload);
        json.put("id", userId);
        json.put("username", username);
        response = request.body(json.toString()).post("/user");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @When("I get the user by username {string}")
    public void iGetTheUserByUsername(String username) {
        response = request.get("/user/" + username);
    }

    @Then("the user ID should be {int}")
    public void theUserIdShouldBe(int expectedUserId) {
        int actualUserId = response.jsonPath().getInt("id");
        Assert.assertEquals(expectedUserId, actualUserId);
    }

    @When("I update the username for user ID {int} to {string}")
    public void iUpdateTheUsernameForUserIdTo(int userId, String newUsername) {
        String payload = PayloadUtils.getPayload("user.json", "updateUser");
        JSONObject json = new JSONObject(payload);
        json.put("id", userId);
        json.put("username", newUsername);
        response = request.body(json.toString()).put("/user/" + currentUsername);
        currentUsername = newUsername;
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("the updated username should be {string}")
    public void theUpdatedUsernameShouldBe(String expectedUsername) {
        response = request.get("/user/" + expectedUsername);
        String actualUsername = response.jsonPath().getString("username");
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @When("I delete the user with ID {int}")
    public void iDeleteTheUserWithId(int userId) {
        response = request.delete("/user/" + userId);
    }

    @Then("the user with ID {int} should not exist")
    public void theUserWithIdShouldNotExist(int userId) {
        response = request.get("/user/" + userId);
        Assert.assertEquals(404, response.getStatusCode());
    }
}
