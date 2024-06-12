# REST In Peace
This project provides an automated testing framework for REST APIs written in Java. It utilizes Cucumber for defining test scenarios in Gherkin format, Rest Assured for sending HTTP requests and validating responses, and leverages the Page Object Model (POM) design pattern for organizing test logic. It targets the [GoREST API](https://gorest.co.in/) for testing purposes.

## Features
* Easy-to-read tests: Scenarios are written in plain English using Gherkin syntax, improving test maintainability and collaboration.
* Reusable steps: Common test actions are defined as reusable steps, promoting code reuse and reducing redundancy.
* REST Assured integration: Leverages Rest Assured's powerful features for efficient API testing.
* Gradle Wrapper: Ensures consistent build environment across different machines.
* Automatic Test Reporting: Generates comprehensive reports after test execution using Cucumber reporting plugins.
* Page Object Model (POM): Organizes test logic by separating page elements (API endpoints in this case) and interactions from the test steps, improving test maintainability and reducing duplication.

## Getting Started

This project uses Gradle for build automation. The Gradle Wrapper included in the project automatically downloads and runs the appropriate Gradle version required by the project. 
While you don't need to install Gradle to run the tests, you will need Java installed on your machine to execute the Java code within the tests. 
Refer to the official [Java download page](https://www.java.com/en/download/) for installation instructions.

* Prerequisites
  * Java 17 or later installed

* Setting Up
  
  1\. Clone this repository: `git clone https://github.com/<your-username>/REST-In-Peace.git` (replace `your-username` with yours)
  
  2\. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse)
  
  3\. Ensure you have Java installed and accessible from the command line.

* Running Tests
  
  1\. Navigate to the project directory in your terminal.
  
  2\. Run the tests using Gradle: `./gradlew apiTest`

* Project Structure
  * `src/test/java/features`: Stores Cucumber feature files describing test scenarios in Gherkin format.
  * `src/test/java/helper`: Houses helper functions for common tasks such as defining endpoints, response models, utilities, and storing JSON Schema data files.
  * `src/test/java/pages`: Contains Page Object Model (POM) classes that encapsulate interactions with specific API endpoints. These classes typically house methods for:
    * Sending HTTP requests (using Rest Assured)
    * Validating response status codes
    * Validating response body structure using JSON Schema or other assertions
    * Extracting data from the response body
  * `src/test/java/runner`: Contains the test runner class responsible for executing the tests and potentially generating reports.
  * `src/test/java/stepDefinition`: Defines the steps used in your feature files, interacting with helper functions and page objects (if applicable).
  * `build.gradle`: The Gradle build configuration file that manages dependencies and build tasks.
