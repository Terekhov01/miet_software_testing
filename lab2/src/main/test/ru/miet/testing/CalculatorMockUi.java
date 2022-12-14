package main.test.ru.miet.testing;

import main.java.ru.miet.testing.Calculator;

public class CalculatorMockUi extends Calculator {
    private String error;
    @Override
    public void displayError(String message) {
        error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
