@calculator
Feature: Calculator
  As a math idiot
  I want to be told the action of two numbers
  So that I can avoid silly mistakes

  @positive @sprint4
  Scenario Outline: Divide_minus_plus_multiply two numbers
    Given I have entered first number <first number> into the calculator
    And I have entered second number <second number> into the calculator
    When I press <action>
    Then the result should be <result> on the screen
    Examples:
      | first number | second number | action | result |
      | 15.0 | 3.0 | divide | 5.0 |
      | 15.0 | 3.0 | minus | 12.0 |
      | 15.0 | 3.0 | plus | 18.0 |
      | 15.0 | 3.0 | multiply | 45.0 |
