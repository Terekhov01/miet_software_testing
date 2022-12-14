package ru.miet.testing.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.ru.miet.testing.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs {
    Calculator calculator;
    public Stepdefs() {
        calculator = new Calculator();
        calculator.setVisible(true);
    }
    @Given("I have entered first number {double} into the calculator")
    public void iHaveEnteredFirstNumberIntoTheCalculator(double arg1) {

        calculator.a.setText(String.valueOf(arg1));
    }

    @And("I have entered second number {double} into the calculator")
    public void iHaveEnteredSecondNumberIntoTheCalculator(double arg2) {
        calculator.b.setText(String.valueOf(arg2));
    }

    @When("I press divide")
    public void iPressDivide() {
        calculator.divide.doClick();
    }

    @When("I press minus")
    public void iPressMinus() {
        calculator.minus.doClick();
    }

    @When("I press multiply")
    public void iPressMultiply() {
        calculator.multiply.doClick();
    }

    @When("I press plus")
    public void iPressPlus() {
        calculator.plus.doClick();
    }

    @Then("the result should be {double} on the screen")
    public void theResultShouldBeOnTheScreen(double arg) {
        assertEquals(String.valueOf(arg), calculator.result.getText());
    }
}
