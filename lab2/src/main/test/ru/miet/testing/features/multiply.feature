@calculator
Feature: Multiply
  As a math idiot
  I want to be told the product of two numbers
  So that I can avoid silly mistakes

  @positive @sprint3
  Scenario: Multiply two numbers
    Given I have entered first number 15.0 into the calculator
    And I have entered second number 3.0 into the calculator
    When I press multiply
    Then the result should be 45.0 on the screen
