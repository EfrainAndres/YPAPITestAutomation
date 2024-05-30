# API test automation

## Overview

This project is a test automation suite for the Swagger Petstore, built using Java with RestAssured and Cucumber. 
The suite includes tests for various features of the Swagger Petstore, ensuring that each functionality works as expected.

## Prerequisites

- Java JDK 11 or higher
- Gradle
- IDE (IntelliJ IDEA recommended)
- Cucumber plugin for the IDE

## Project Structure

```
PetStoreAPI/
│
├── src/
│ ├── test/
│ │ ├── java/
│ │ │ ├── co/com/yellowpepper/
│ │ │ │ ├── config/
│ │ │ │ │ └── BaseTest.java
│ │ │ │ ├── runner/
│ │ │ │ │ └── CucumberTestRunner.java
│ │ │ │ ├── steps/
│ │ │ │ │ ├── PetSteps.java
│ │ │ │ │ ├── StoreSteps.java
│ │ │ │ │ └── UserSteps.java
│ │ │ │ └── utils/
│ │ │ │ ├── LoggerUtil.java
│ │ │ │ └── PayloadUtils.java
│ │ ├── resources/
│ │ ├── features/
│ │ │ ├── pet.feature
│ │ │ ├── store.feature
│ │ │ ├── user.feature
│ │ └── payloads/
│ │ ├── pet.json
│ │ ├── store.json
│ │ └── user.json
│
├── .gitignore
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
└── gradlew.bat
```
## Running Tests

To run the tests, use the following command in the project root directory:

```bash
./gradlew test
```

## Cucumber Test Scenarios

### Pet Feature

The `pet.feature` file contains scenarios related to pet management in the application.

#### Scenarios:

1. **Add a New Pet**
   - **Given**: A new pet payload is provided. This payload includes details such as the pet's name, category, status, and other attributes.
   - **When**: The user sends a POST request to the `/pet` endpoint with the pet payload.
   - **Then**: The pet is successfully added, and a response with status code 200 is received. The response body contains the details of the newly added pet, including its ID.

2. **Update an Existing Pet**
   - **Given**: An existing pet payload with updated information is provided. This payload includes the pet's ID and the updated details.
   - **When**: The user sends a PUT request to the `/pet` endpoint with the updated pet payload.
   - **Then**: The pet information is successfully updated, and a response with status code 200 is received. The response body contains the updated details of the pet.

3. **Delete a Pet**
   - **Given**: An existing pet ID is provided.
   - **When**: The user sends a DELETE request to the `/pet/{petId}` endpoint with the pet ID.
   - **Then**: The pet is successfully deleted, and a response with status code 200 is received confirming the deletion.

### Store Feature

The `store.feature` file contains scenarios related to store operations in the application.

#### Scenarios:

1. **Place an Order**
   - **Given**: A new order payload is provided. This payload includes details such as the pet ID, quantity, ship date, and order status.
   - **When**: The user sends a POST request to the `/store/order` endpoint with the order payload.
   - **Then**: The order is successfully placed, and a response with status code 200 is received. The response body contains the details of the newly placed order, including its ID.

2. **Get Order by ID**
   - **Given**: An existing order ID is provided.
   - **When**: The user sends a GET request to the `/store/order/{orderId}` endpoint with the order ID.
   - **Then**: The order details are retrieved successfully, and a response with status code 200 is received. The response body contains the details of the order.

3. **Delete an Order**
   - **Given**: An existing order ID is provided.
   - **When**: The user sends a DELETE request to the `/store/order/{orderId}` endpoint with the order ID.
   - **Then**: The order is successfully deleted, and a response with status code 200 is received confirming the deletion.

### User Feature

The `user.feature` file contains scenarios related to user management in the application.

#### Scenarios:

1. **Create a New User**
   - **Given**: A new user payload is provided. This payload includes details such as the username, first name, last name, email, password, and phone number.
   - **When**: The user sends a POST request to the `/user` endpoint with the user payload.
   - **Then**: The user is successfully created, and a response with status code 200 is received. The response body contains the details of the newly created user, including its ID.

2. **Get User by Username**
   - **Given**: An existing username is provided.
   - **When**: The user sends a GET request to the `/user/{username}` endpoint with the username.
   - **Then**: The user details are retrieved successfully, and a response with status code 200 is received. The response body contains the details of the user.

3. **Delete a User**
   - **Given**: An existing username is provided.
   - **When**: The user sends a DELETE request to the `/user/{username}` endpoint with the username.
   - **Then**: The user is successfully deleted, and a response with status code 200 is received confirming the deletion.


## Test Results

<img width="578" alt="image" src="https://github.com/EfrainAndres/YPAPITestAutomation/assets/20568951/e1371855-37ee-4d59-a942-09bc2299b437">

<img width="578" alt="image" src="https://github.com/EfrainAndres/YPAPITestAutomation/assets/20568951/87436b62-edc0-4e91-900b-7a69478ac0f5">

<img width="578" alt="image" src="https://github.com/EfrainAndres/YPAPITestAutomation/assets/20568951/a33f44a0-7161-4f00-a691-8d45656d0723">



