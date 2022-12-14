package main.test.ru.miet.testing;

import main.java.ru.miet.testing.interfaces.CalculatorPresenter;
import main.java.ru.miet.testing.implementation.CalculatorPresenterImpl;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestCalculator {
    private final CalculatorMock mock = new CalculatorMock();
    private final CalculatorPresenter calcPres = new CalculatorPresenterImpl(mock);
    private final String[] errors = {"Wrong number", "Enter a number", "Divide by zero"};

    @Test
    public void firstArgIsNullPlus() {
        mock.setA(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onPlusClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void firstArgIsNullMinus() {
        mock.setA(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onMinusClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void firstArgIsNullDivide() {
        mock.setA(null);
        mock.setB(String.valueOf(Math.random()));
        calcPres.onDivideClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void firstArgIsNullMultiply() {
        mock.setA(null);
        mock.setB(String.valueOf(Math.random()));
        calcPres.onMultiplyClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void secondArgIsNullPlus() {
        mock.setB(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onPlusClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void secondArgIsNullMinus() {
        mock.setB(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onMinusClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void secondArgIsNullDivide() {
        mock.setB(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onDivideClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void secondArgIsNullMultiply() {
        mock.setB(null);
        mock.setA(String.valueOf(Math.random()));
        calcPres.onMultiplyClicked();
        assertEquals(errors[1],mock.getError());
    }
    @Test
    public void divideByZero() {
        mock.setA(String.valueOf(Math.random()));
        mock.setB(String.valueOf(Math.random()*10e-8));
        calcPres.onDivideClicked();
        assertEquals(errors[2],mock.getError());
    }
    @Test
    public void firstArgIsNaNPlus() {
        mock.setA("Random string");
        mock.setB(String.valueOf(Math.random()));
        calcPres.onPlusClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void firstArgIsNaNMinus() {
        mock.setA("Random string");
        mock.setB(String.valueOf(Math.random()));
        calcPres.onMinusClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void firstArgIsNaNDivide() {
        mock.setA("Random string");
        mock.setB(String.valueOf(Math.random()));
        calcPres.onDivideClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void firstArgIsNaNMultiply() {
        mock.setA("Random string");
        mock.setB(String.valueOf(Math.random()));
        calcPres.onMultiplyClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void secondArgIsNaNPlus() {
        mock.setB("Random string");
        mock.setA(String.valueOf(Math.random()));
        calcPres.onPlusClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void secondArgIsNaNMinus() {
        mock.setB("Random string");
        mock.setA(String.valueOf(Math.random()));
        calcPres.onMinusClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void secondArgIsNaNDivide() {
        mock.setB("Random string");
        mock.setA(String.valueOf(Math.random()));
        calcPres.onDivideClicked();
        assertEquals(errors[0],mock.getError());
    }
    @Test
    public void secondArgIsNaNMultiply() {
        mock.setB("Random string");
        mock.setA(String.valueOf(Math.random()));
        calcPres.onMultiplyClicked();
        assertEquals(errors[0],mock.getError());
    }
    @RepeatedTest(100)
    public void plusTest() {
        double a = Math.random();
        double b = Math.random();
        mock.setA(String.valueOf(a));
        mock.setB(String.valueOf(b));
        calcPres.onPlusClicked();
        assertEquals(a+b,mock.getResult());
    }
    @RepeatedTest(100)
    public void minusTest() {
        double a = Math.random();
        double b = Math.random();
        mock.setA(String.valueOf(a));
        mock.setB(String.valueOf(b));
        calcPres.onMinusClicked();
        assertEquals(a-b,mock.getResult());
    }
    @RepeatedTest(100)
    public void divideTest() {
        double a = Math.random();
        double b = Math.random()+10e-7;
        mock.setA(String.valueOf(a));
        mock.setB(String.valueOf(b));
        calcPres.onDivideClicked();
        assertEquals(a/b,mock.getResult());
    }
    @RepeatedTest(100)
    public void multiplyTest() {
        double a = Math.random();
        double b = Math.random();
        mock.setA(String.valueOf(a));
        mock.setB(String.valueOf(b));
        calcPres.onMultiplyClicked();
        assertEquals(a*b,mock.getResult());
    }
}
