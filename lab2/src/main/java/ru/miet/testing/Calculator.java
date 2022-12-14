package main.java.ru.miet.testing;

import main.java.ru.miet.testing.implementation.CalculatorPresenterImpl;
import main.java.ru.miet.testing.interfaces.CalculatorPresenter;
import main.java.ru.miet.testing.interfaces.CalculatorView;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements CalculatorView {
    public JTextField a = new JTextField("", 5);
    public JTextField b = new JTextField("", 5);
    public JLabel result = new JLabel("",SwingConstants.CENTER);
    public JLabel equals = new JLabel("=",SwingConstants.CENTER);
    public JButton plus = new JButton("+");
    public JButton minus = new JButton("-");
    public JButton multiply = new JButton("*");
    public JButton divide = new JButton("/");
    private final CalculatorPresenter calcPres;

    public Calculator() throws HeadlessException {
        super("Calculator");
        calcPres = new CalculatorPresenterImpl(this);
        setBounds(50,50,700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1,2,2));
        p1.add(new JLabel(""));
        a.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        a.setHorizontalAlignment(JTextField.CENTER);
        p1.add(a);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4,1,2,2));
        plus.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        minus.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        multiply.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        divide.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        p2.add(plus);
        p2.add(minus);
        p2.add(multiply);
        p2.add(divide);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(3,1,2,2));
        p3.add(new JLabel(""));
        b.setFont(new Font(equals.getFont().getName(),Font.PLAIN,40));
        b.setHorizontalAlignment(JTextField.CENTER);
        p3.add(b);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3,1,2,2));
        p4.add(new JLabel(""));
        equals.setFont(new Font(equals.getFont().getName(),Font.PLAIN,30));
        p4.add(equals);

        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        result.setFont(new Font(equals.getFont().getName(),Font.PLAIN,30));
        p5.add(result, BorderLayout.CENTER);

        container.setLayout(new GridLayout(1,5,2,2));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.add(p4);
        container.add(p5);

        plus.addActionListener(e -> calcPres.onPlusClicked());
        minus.addActionListener(e -> calcPres.onMinusClicked());
        multiply.addActionListener(e -> calcPres.onMultiplyClicked());
        divide.addActionListener(e -> calcPres.onDivideClicked());
    }

    @Override
    public void printResult(double result) {
        this.result.setText(String.valueOf(result));
    }

    @Override
    public void displayError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public String getFirstArgumentAsString() {
        return a.getText();
    }

    @Override
    public String getSecondArgumentAsString() {
        return b.getText();
    }
}
