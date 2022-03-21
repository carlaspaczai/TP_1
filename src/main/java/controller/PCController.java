package controller;
import model.Monom;
import model.Operations;
import model.Polynom;
import view.PCView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;
import static java.lang.Integer.parseInt;

public class PCController {
    PCView CView;
    Polynom intermediatePolynom;

    public PCController(PCView CView, Polynom intermediatePolynom) {
        this.CView = CView;
        this.intermediatePolynom = intermediatePolynom;
        this.CView.addListener(new AddListener());
        this.CView.subtractListener(new SubtractListener());
        this.CView.multiplicateListener(new MultiplicateListener());
        this.CView.derivativeListener(new DerivativeListener());
        this.CView.integralListener(new IntegralListener());
        this.CView.divisionListener(new DivisionListener());
    }

    public Polynom regexPattern1() {
        Pattern regex = Pattern.compile("([+-]?(?:(?:\\d+X\\^\\d+)|(?:\\d+X)|(?:\\d+)|(?:X)))");
        Matcher givenPolynom1 = regex.matcher(CView.getFirstPolynomialTF());
        Polynom resultPolynom = new Polynom();
        int coeficient, exponent;
        while(givenPolynom1.find()) {
            String stringMonom = String.valueOf(givenPolynom1.group());
            if(stringMonom.charAt(0) == '+') {
                coeficient = parseInt(String.valueOf(stringMonom.charAt(1)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(4)));
            } else if(stringMonom.charAt(0) == '-') {
                coeficient = (-1) * parseInt(String.valueOf(stringMonom.charAt(1)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(4)));
            } else {
                coeficient = parseInt(String.valueOf(stringMonom.charAt(0)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(3)));
            }
            Monom intermediateMonom = new Monom(exponent, coeficient);
            resultPolynom.addMonom(intermediateMonom);
        }
        return resultPolynom;
    }

    public Polynom regexPattern2() {
        Pattern regex = Pattern.compile("([+-]?(?:(?:\\d+X\\^\\d+)|(?:\\d+X)|(?:\\d+)|(?:X)))");
        Matcher givenPolynom2 = regex.matcher(CView.getSecondPolynomialTF());
        Polynom resultPolynom = new Polynom();
        int coeficient, exponent;
        while(givenPolynom2.find()) {
            String stringMonom = String.valueOf(givenPolynom2.group());
            if(stringMonom.charAt(0) == '+') {
                coeficient = parseInt(String.valueOf(stringMonom.charAt(1)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(4)));
            } else if(stringMonom.charAt(0) == '-') {
                coeficient = (-1) * parseInt(String.valueOf(stringMonom.charAt(1)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(4)));
            } else {
                coeficient = parseInt(String.valueOf(stringMonom.charAt(0)));
                exponent = parseInt(String.valueOf(stringMonom.charAt(3)));
            }
            Monom intermediateMonom = new Monom(exponent, coeficient);
            resultPolynom.addMonom(intermediateMonom);
        }
        return resultPolynom;
    }

    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            Polynom P2 = new Polynom();
            P1 = regexPattern1();
            P2 = regexPattern2();
            Polynom result = Operations.addPolynoms(P1, P2);
            CView.getResultTF().setText(result.toString());
        }
    }

    public class SubtractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            Polynom P2 = new Polynom();
            P1 = regexPattern1();
            P2 = regexPattern2();
            Polynom result = Operations.subtractPolynoms(P1, P2);
            CView.getResultTF().setText(result.toString());
        }
    }

    public class MultiplicateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            Polynom P2 = new Polynom();
            P1 = regexPattern1();
            P2 = regexPattern2();
            Polynom result = Operations.multiplicatePolynoms(P1, P2);
            CView.getResultTF().setText(result.toString());
        }
    }

    public class DerivativeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            P1 = regexPattern1();
            Polynom result = Operations.derivativePolynoms(P1);
            CView.getResultTF().setText(result.toString());
        }
    }

    public class IntegralListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            P1 = regexPattern1();
            Polynom result = Operations.integralPolynoms(P1);
            CView.getResultTF().setText(result.toString() + "+C");
        }
    }

    public class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynom P1 = new Polynom();
            Polynom P2 = new Polynom();
            P1 = regexPattern1();
            P2 = regexPattern2();
            Polynom result = Operations.divisionPolynoms(P1, P2);
            CView.getResultTF().setText("Quotient: " + result.toString() + " Remainder: " + Operations.getDivisionRemainder().toString());
        }
    }
}
