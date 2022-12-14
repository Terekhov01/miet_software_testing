package main.test.ru.miet.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {
    private static CalculatorMockUi mock;
    private static Robot robot;
    private static double a;
    private static double b;
    private final String[] errors = {"Wrong number", "Enter a number", "Divide by zero"};

    @BeforeAll
    public static void prepare(){
        mock = new CalculatorMockUi();
        mock.setVisible(true);
        mock.setExtendedState(Frame.MAXIMIZED_BOTH);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        a = Math.random();
        b = Math.random();
    }

    public void click(JButton button, int dx, int dy) throws InterruptedException {
        Point p = button.getLocationOnScreen();
        robot.mouseMove(-1000,-1000);
        robot.mouseMove(p.x+dx,p.y+dy);
        //Thread.sleep(10);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thread.sleep(10);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
    }
    private void setA(double a) throws InterruptedException {
        mock.a.setText(Double.toString(a));
        Thread.sleep(20);
    }
    private void setB(double b) throws InterruptedException {
        mock.b.setText(Double.toString(b));
        Thread.sleep(20);
    }

    @Test
    public void testPlus() throws InterruptedException {
        setA(a);
        setB(b);
        click(mock.plus, 10, 10);
        assertEquals(Double.toString(a + b), mock.result.getText());
        Thread.sleep(100);
    }
    @Test
    public void testMinus() throws InterruptedException {
        setA(a);
        setB(b);
        click(mock.minus,10, 10);
        assertEquals(Double.toString(a - b), mock.result.getText());
        Thread.sleep(100);
    }
    @Test
    public void testMultiply() throws InterruptedException {
        setA(a);
        setB(b);
        click(mock.multiply, 10, 10);
        assertEquals(Double.toString(a * b), mock.result.getText());
        Thread.sleep(100);
    }
    @Test
    public void testDivide() throws InterruptedException {
        setA(a);
        setB(b+10e-8);
        click(mock.divide, 10, 10);
        assertEquals(Double.toString(a / (b+10e-8)), mock.result.getText());
        Thread.sleep(100);
    }
    @Test
    public void testNullPlusB() throws InterruptedException {
        mock.a.setText(null);
        Thread.sleep(100);
        setB(b);
        click(mock.plus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNullMinusB() throws InterruptedException {
        mock.a.setText(null);
        Thread.sleep(100);
        setB(b);
        click(mock.minus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNullMultiplyB() throws InterruptedException {
        mock.a.setText(null);
        Thread.sleep(100);
        setB(b);
        click(mock.multiply, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNullDivideB() throws InterruptedException {
        mock.a.setText(null);
        Thread.sleep(100);
        setB(b);
        click(mock.divide, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAPlusNull() throws InterruptedException {
        mock.b.setText(null);
        Thread.sleep(100);
        setA(a);
        click(mock.plus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAMinusNull() throws InterruptedException {
        mock.b.setText(null);
        Thread.sleep(100);
        setA(a);
        click(mock.minus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAMultiplyNull() throws InterruptedException {
        mock.b.setText(null);
        Thread.sleep(100);
        setA(a);
        click(mock.multiply, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testADivideNull() throws InterruptedException {
        mock.b.setText(null);
        Thread.sleep(100);
        setA(a);
        click(mock.divide, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }

    @Test
    public void testNaNPlusB() throws InterruptedException {
        mock.a.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(mock.plus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNaNMinusB() throws InterruptedException {
        mock.a.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(mock.minus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNaNMultiplyB() throws InterruptedException {
        mock.a.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(mock.multiply, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testNaNDivideB() throws InterruptedException {
        mock.a.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(mock.divide, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAPlusNaN() throws InterruptedException {
        mock.b.setText("Random");
        Thread.sleep(100);
        setA(a);
        click(mock.plus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAMinusNaN() throws InterruptedException {
        setB(b);
        //mock.b.setText("Random");
        Thread.sleep(100);
        setA(a);
        click(mock.minus, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testAMultiplyNaN() throws InterruptedException {
        mock.b.setText("Random");
        Thread.sleep(100);
        setA(a);
        click(mock.multiply, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testADivideNaN() throws InterruptedException {
        mock.b.setText("Random");
        Thread.sleep(100);
        setA(a);
        click(mock.divide, 10, 10);
        assertEquals(mock.getError(),errors[0]);
    }
    @Test
    public void testDivideByZero() throws  InterruptedException {
        mock.b.setText("0");
        Thread.sleep(10);
        setA(a);
        click(mock.divide,10, 10);
        assertEquals(mock.getError(),errors[2]);
    }
}
