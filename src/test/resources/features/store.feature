Feature: Store management

  Scenario: Place an order
    Given I place an order with ID 200 for pet ID 123 with status "placed"
    When I get the order by ID 200
    Then the order status should be "placed"

  Scenario: Get inventory status
    When I get the store inventory
    Then the response should contain inventory details

  Scenario: Delete an order
    Given I place an order with ID 201 for pet ID 124 with status "delivered"
    When I delete the order with ID 201
    Then the order with ID 201 should not exist
