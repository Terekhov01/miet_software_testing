@calculator
Feature: Divide
  As a math idiot
  I want to be told the division of two numbers
  So that I can avoid silly mistakes

  @positive @sprint4
  Scenario: Divide two numbers
    Given I have entered first number 15.0 into the calculator
    And I have entered second number 3.0 into the calculator
    When I press divide
    Then the result should be 5.0 on the screen

