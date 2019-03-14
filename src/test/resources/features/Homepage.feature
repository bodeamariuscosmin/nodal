@test
Feature: Contact page tests

  Background:
    Given I navigate to "contact page"
    Then the title of the page should be "Contact | Nodal"
    When I click the "close cookies modal" button from the Contact page

  Scenario: Valid contact us test
    Then I input "unique name" in the "name" field from the Contact page
    Then I input "unique email" in the "email" field from the Contact page
    Then I input "valid text" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "be" submitted successfully

  Scenario: Missing name contact us test
    Then I input "" in the "name" field from the Contact page
    Then I input "unique email" in the "email" field from the Contact page
    Then I input "valid text" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "not be" submitted successfully

  Scenario: To short name contact us test
    Then I input "too short name" in the "name" field from the Contact page
    Then I input "unique email" in the "email" field from the Contact page
    Then I input "valid text" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "not be" submitted successfully

  Scenario: To long name contact us test
    Then I input "too long name" in the "name" field from the Contact page
    Then I input "unique email" in the "email" field from the Contact page
    Then I input "valid text" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "not be" submitted successfully

  Scenario: Invalid email contact us test
    Then I input "unique name" in the "name" field from the Contact page
    Then I input "invalid email" in the "email" field from the Contact page
    Then I input "valid text" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "not be" submitted successfully

  Scenario: Empty message contact us test
    Then I input "unique name" in the "name" field from the Contact page
    Then I input "unique email" in the "email" field from the Contact page
    Then I input "" in the "message" field from the Contact page
    When I click the "Send Message" button from the Contact page
    Then the form should "not be" submitted successfully

