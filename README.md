# Introduction

## Tools
After analyzing the products and various automation tools, we selected [Playwright](https://playwright.dev/java/). which is one of the most popular open‐source functional and regression testing tools and very well suited for this product requirments. We went through the application, understood its functionality and work‐flow, and prepared our automation plan.
We designed a high level hybrid framework which made the scripts very easy to run even for non-technical users.
We developed sufficient sets of scripts to be simply run whenever there was a change in the application. Also, we have introduced cucumber with playwright for test case writing in gherken formet. So tech and non-tech both parties understand the test details.

 - **Playwright:** _v1.25.0_
 - **Java:** _v11.0.12_
 - **Cucumber:** _v7.6.0_
 - **Junit:** _v5.9.0_
 - **Extent Report:** _v5.0.9_
 - **Extent Report Adapter(PDF):** _v1.7.0_
 
# Getting Started

**TODO:** Guide users through getting your code up and running on their own system. In this section you can talk about:

1. Installation process
2. Software dependencies
3. Latest releases
4. API references

## Browser Configuration

#### For now, This project has configured with one browser, we can easily create more browser later on.

1. Chrome
2. Firefox(For Future)
3. Edge(For Future)
4. Safari(For Future)

![browser, support!](https://playwright.dev/java/img/logos/Browsers.png)

## Environments Configuration

#### For now, This project has configured with one environment, we can easily create more development environment

1. Local(For Local machine)
2. Dev(For Future)

## Test Case list

#### For now, This project has below test classes

1. LoginTest


## Build and Test with different environment

 *Below are command to run automation script with different environment:*

    mvn test -Denv=<environment name>
    (ex: mvn test -Denv=Dev)

## Build and run individual Test cases with different environment

 *Below are command to run automation script with different environment and individual test cases*

    mvn test -Denv=<environmentName> -Dtest=<test case name>
    (ex: mvn test -Denv=local -Dtest=LoginTest)

# Contribute

TODO: Explain how other users and developers can contribute to make your code better.

* Git repository collaboration rules
