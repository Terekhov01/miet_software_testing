package main.java.ru.miet.testing.implementation;

import main.java.ru.miet.testing.interfaces.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (Math.abs(b) < 10e-8) throw new ArithmeticException();
        return a / b;
    }
}
