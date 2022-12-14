package main.test.ru.miet.testing;

import main.java.ru.miet.testing.interfaces.CalculatorView;

public class CalculatorMock implements CalculatorView {
    private String a,b;
    private double result;
    private String error;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setError(String error) {
        this.error = error;
    }

    public double getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    @Override
    public void printResult(double result) {
        this.result=result;
    }
    @Override
    public void displayError(String message) {
        error = message;
    }
    @Override
    public String getFirstArgumentAsString() {
        return a;
    }
    @Override
    public String getSecondArgumentAsString() {
        return b;
    }
}
