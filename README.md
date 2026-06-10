<!-- README_PRESENTATION_START -->
<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=rect&height=140&color=0:0F172A,100:14B8A6&text=Selenium%20POM%20Framework&fontColor=FFFFFF&fontSize=30&fontAlignY=42&desc=Clean%20Page%20Object%20Model%20framework%20with%20TestNG%20and%20Allure&descAlignY=68&descSize=15" alt="Selenium POM Framework banner" />
</p>

<p align="center">
  <img alt="Java: 11" src="https://img.shields.io/badge/Java-11-007396?style=for-the-badge" /> <img alt="Selenium: POM" src="https://img.shields.io/badge/Selenium-POM-43B02A?style=for-the-badge" /> <img alt="TestNG: Runner" src="https://img.shields.io/badge/TestNG-Runner-0B5CAD?style=for-the-badge" /> <img alt="Allure: Reports" src="https://img.shields.io/badge/Allure-Reports-FF6A00?style=for-the-badge" /> <img alt="Pattern: Page Objects" src="https://img.shields.io/badge/Pattern-Page%20Objects-14B8A6?style=for-the-badge" />
</p>

<table>
  <tr><td><strong>Role signal</strong></td><td>Classic Selenium framework and maintainable UI tests</td></tr>
<tr><td><strong>What to inspect</strong></td><td><code>BasePage</code>, <code>BaseTest</code>, <code>DriverFactory</code>, page classes</td></tr>
<tr><td><strong>Best for</strong></td><td>QA Automation roles requiring Selenium and POM</td></tr>
</table>

<!-- README_PRESENTATION_END -->

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
