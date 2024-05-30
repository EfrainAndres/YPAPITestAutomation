Feature: User management

  Scenario: Create a user
    Given I create a user with username "testuser" and ID 300
    When I get the user by username "testuser"
    Then the user ID should be 300

  Scenario: Update user information
    Given I create a user with username "john_doe" and ID 301
    When I update the username for user ID 301 to "john_smith"
    Then the updated username should be "john_smith"

  Scenario: Delete a user
    Given I create a user with username "jane_doe" and ID 302
    When I delete the user with ID 302
    Then the user with ID 302 should not exist