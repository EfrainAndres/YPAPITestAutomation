Feature: Pet management

  Scenario: Create a pet
    Given I create a pet with ID 123 and name "Doggie"
    When I get the pet by ID 123
    Then the pet name should be "Doggie"

  Scenario: Update a pet
    Given I create a pet with ID 124 and name "Kitty"
    When I update the pet with ID 124 to name "KittyUpdated"
    Then the pet name should be "KittyUpdated"

  Scenario: Delete a pet
    Given I create a pet with ID 125 and name "Parrot"
    When I delete the pet with ID 125
    Then the pet with ID 125 should not exist