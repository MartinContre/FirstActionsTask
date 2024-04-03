@allure.label.layer:web
@allure.label.owner:martin
@allure.label.page:/{org}/{repo}/labels
Feature: Userinyerface
  Validate several cases for useinyerface page

  Background:
    Given Welcome page is open
    When User clicks please click here to go button
    Then First card is open

  Scenario: Navigate throw 3 card
    When User inputs a random valid password, email, accept the terms of use, and click next button
    Then The second card should be open
    When User chooses 3 random interests, upload an image, and click Next button
    Then The third card is opened

  Scenario: Hide help form
    When User clicks hide help form
    Then Form content is hidden

  Scenario: Cookies form is closed when accepted
    When Click accept cookies button
    Then Cookies form is closed

  Scenario: Timer starts from "00:00" after navigating to the home page
    Then Timer starts from "00:00"

  Scenario Outline: User navigation and interaction on the website
    And User writes values, accept the terms of use, and click next button
      | email      | password   | domain  |
      | pdfbjbargz | зdlуwрB7nC | outlook |
    Then The second card should be open
    And User chooses <numOfInterests> random interests, upload an image, and click Next button
    Then The third card is <status>

    Examples:
      | numOfInterests | status    |
      | 3              | opened    |
      | 2              | notOpened |
      | 4              | notOpened |