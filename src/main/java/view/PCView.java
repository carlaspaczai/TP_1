package view;
import java.awt.event.*;
import javax.swing.*;

public class PCView extends JPanel {
    private JButton addButton;
    private JButton multiplicateButton;
    private JButton subtractButton;
    private JLabel titleLabel;
    private JLabel firstPolynomialLabel;
    private JLabel secondPolynomialLabel;
    private JTextField firstPolynomialTF;
    private JTextField secondPolynomialTF;
    private JButton divideButton;
    private JButton derivativeButton;
    private JButton integralButton;
    private JTextField resultTF;
    private JLabel resultLabel;

    public PCView() {
        JFrame F = new JFrame("MyPanel");
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout (null);
        addButton = new JButton ("Add");
        F.add (addButton);
        addButton.setBounds (40, 170, 240, 40);
        multiplicateButton = new JButton ("Multiplicate");
        F.add (multiplicateButton);
        multiplicateButton.setBounds (40, 215, 240, 40);
        subtractButton = new JButton ("Subtract");
        F.add (subtractButton);
        subtractButton.setBounds (285, 170, 240, 40);
        titleLabel = new JLabel ("Polynomial Calculator");
        F.add (titleLabel);
        titleLabel.setBounds (215, 10, 125, 35);
        firstPolynomialLabel = new JLabel ("First Polynomial: ");
        F.add (firstPolynomialLabel);
        firstPolynomialLabel.setBounds (57, 55, 100, 30);
        secondPolynomialLabel = new JLabel ("Second Polynomial: ");
        F.add (secondPolynomialLabel);
        secondPolynomialLabel.setBounds (40, 85, 115, 30);
        firstPolynomialTF = new JTextField (100);
        F.add (firstPolynomialTF);
        firstPolynomialTF.setBounds (155, 60, 370, 25);
        secondPolynomialTF = new JTextField (100);
        F.add (secondPolynomialTF);
        secondPolynomialTF.setBounds (155, 90, 370, 25);
        divideButton = new JButton ("Divide");
        F.add (divideButton);
        divideButton.setBounds (285, 215, 240, 40);
        derivativeButton = new JButton ("Derivative");
        F.add (derivativeButton);
        derivativeButton.setBounds (40, 260, 240, 40);
        integralButton = new JButton ("Integral");
        F.add (integralButton);
        integralButton.setBounds (285, 260, 240, 40);
        resultTF = new JTextField (100);
        F.add (resultTF);
        resultTF.setBounds (155, 120, 370, 45);
        resultLabel = new JLabel ("");
        F.add (resultLabel);
        resultLabel.setBounds (110, 130, 45, 25);

        F.setSize(565, 360);
        F.setVisible(true);
    }

    public String getFirstPolynomialTF() {
        return firstPolynomialTF.getText();
    }

    public String getSecondPolynomialTF() {
        return secondPolynomialTF.getText();
    }

    public JTextField getResultTF() {
        return resultTF;
    }

    public void addListener(ActionListener addButtonListener) {
        addButton.addActionListener(addButtonListener);
    }

    public void subtractListener(ActionListener subtractButtonListener) {
        subtractButton.addActionListener(subtractButtonListener);
    }

    public void multiplicateListener(ActionListener multiplicateButtonListener) {
        multiplicateButton.addActionListener(multiplicateButtonListener);
    }

    public void derivativeListener(ActionListener derivativeButtonListener) {
        derivativeButton.addActionListener(derivativeButtonListener);
    }

    public void integralListener(ActionListener integralButtonListener) {
        integralButton.addActionListener(integralButtonListener);
    }

    public void divisionListener(ActionListener divisionButtonListener) {
        divideButton.addActionListener(divisionButtonListener);
    }
}
