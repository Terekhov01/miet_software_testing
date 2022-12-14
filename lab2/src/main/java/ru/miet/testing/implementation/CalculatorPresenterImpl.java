package main.java.ru.miet.testing.implementation;


import main.java.ru.miet.testing.interfaces.CalculatorPresenter;
import main.java.ru.miet.testing.interfaces.CalculatorView;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private final CalculatorImpl calculator;
    private final CalculatorView calculatorView;

    private double a;
    private double b;

    public void setA(Double a) {
        this.a = a;
    }

    public void setB(Double b) {
        this.b = b;
    }

    private boolean isErrorCaught = false;

    public CalculatorPresenterImpl(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        this.calculator = new CalculatorImpl();
    }

    private void getNumbers(){
        isErrorCaught = false;
        try {
            a = Double.parseDouble(calculatorView.getFirstArgumentAsString());
            b = Double.parseDouble(calculatorView.getSecondArgumentAsString());
        } catch(NumberFormatException e) {
            isErrorCaught = true;
            calculatorView.displayError("Wrong number");
        } catch(NullPointerException e) {
            isErrorCaught = true;
            calculatorView.displayError("Enter a number");
        }
    }

    @Override
    public void onPlusClicked() {
        getNumbers();
        if(isErrorCaught) return;
        calculatorView.printResult(calculator.sum(a,b));
    }

    @Override
    public void onMinusClicked() {
        getNumbers();
        if(isErrorCaught) return;
        calculatorView.printResult(calculator.subtract(a,b));
    }

    @Override
    public void onDivideClicked() {
        getNumbers();
        if(isErrorCaught) return;
        try {
            calculatorView.printResult(calculator.divide(a,b));
        } catch(ArithmeticException e) {
            calculatorView.displayError("Divide by zero");
        }
    }

    @Override
    public void onMultiplyClicked() {
        getNumbers();
        if(isErrorCaught) return;
        calculatorView.printResult(calculator.multiply(a, b));
    }
}
