# Selenium POM Framework

Focused Java Selenium framework demonstrating Page Object Model design, TestNG execution, WebDriverManager setup, and Allure reporting.

This repository is a compact automation framework built around one clear idea: UI tests should be readable at the test level and maintainable through page objects, shared base classes, and centralized driver configuration.

## What This Project Demonstrates

- Page Object Model implementation;
- Selenium WebDriver automation;
- TestNG execution model;
- WebDriverManager browser setup;
- Allure TestNG reporting;
- reusable base page and base test classes;
- configuration reader utility;
- clean separation between test flow and locator/action logic.

## Technology Stack

| Area | Tools |
|---|---|
| Language | Java 11 |
| Build | Maven |
| UI automation | Selenium WebDriver |
| Test runner | TestNG |
| Browser setup | WebDriverManager |
| Reporting | Allure |
| Logging | SLF4J |
| AOP/report integration | AspectJ |

## Repository Structure

```text
src/main/java/com/pomframewrok/
  base/
    BasePage.java
    BaseTest.java
    DriverFactory.java

  pages/
    LoginPage.java
    ProductPage.java

  utils/
    AllureManager.java
    ConfigReader.java

src/test/resources/
  testng.xml
```

## Design Notes

### `BasePage`

Provides common page-level behavior so page classes can focus on domain actions instead of raw WebDriver calls.

### `BaseTest`

Centralizes test setup and teardown. This keeps browser lifecycle handling out of individual tests.

### `DriverFactory`

Encapsulates browser creation and keeps the framework ready for multi-browser or environment-specific execution.

### Page classes

`LoginPage` and `ProductPage` represent UI screens as objects with meaningful actions. This makes tests easier to read and reduces locator duplication.

### Allure integration

`AllureManager` and Allure dependencies prepare the framework for readable execution reports and debugging artifacts.

## Running Locally

Requirements:

- Java 11;
- Maven;
- Chrome or another configured browser.

Run the test suite:

```bash
mvn test
```

Generate and serve Allure report:

```bash
mvn allure:serve
```

## What To Review First

1. `BasePage.java` for shared UI abstractions.
2. `BaseTest.java` for lifecycle handling.
3. `DriverFactory.java` for driver setup.
4. `LoginPage.java` and `ProductPage.java` for Page Object Model examples.
5. `pom.xml` for Selenium, TestNG, WebDriverManager, and Allure setup.

## Recruiter Signal

This project is a clean signal for classic QA Automation roles:

- Java;
- Selenium;
- Page Object Model;
- TestNG;
- Maven;
- Allure reporting;
- framework basics.

It is best positioned as a compact POM framework example rather than a large enterprise test platform.
