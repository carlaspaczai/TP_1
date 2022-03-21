import model.Monom;
import model.Operations;
import model.Polynom;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestClass {
    @Test
    public void testAddPolynoms() {
        Polynom P1 = new Polynom();
        Polynom P2 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(5, 4));
        P1.addMonom(new Monom(4, -3));
        P1.addMonom(new Monom(2, 1));
        P1.addMonom(new Monom(1, -8));
        P1.addMonom(new Monom(0, 1));
        P2.addMonom(new Monom(4, 3));
        P2.addMonom(new Monom(3, -1));
        P2.addMonom(new Monom(2, 1));
        P2.addMonom(new Monom(1, 2));
        P2.addMonom(new Monom(0, -1));
        Rez.addMonom(new Monom(5, 4));
        Rez.addMonom(new Monom(3, -1));
        Rez.addMonom(new Monom(2, 2));
        Rez.addMonom(new Monom(1, -6));
        String S1 = Operations.addPolynoms(P1, P2).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testSubtractPolynoms() {
        Polynom P1 = new Polynom();
        Polynom P2 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(5, 4));
        P1.addMonom(new Monom(4, -3));
        P1.addMonom(new Monom(2, 1));
        P1.addMonom(new Monom(1, -8));
        P1.addMonom(new Monom(0, 1));
        P2.addMonom(new Monom(4, 3));
        P2.addMonom(new Monom(3, -1));
        P2.addMonom(new Monom(2, 1));
        P2.addMonom(new Monom(1, 2));
        P2.addMonom(new Monom(0, -1));
        Rez.addMonom(new Monom(5, 4));
        Rez.addMonom(new Monom(4, -6));
        Rez.addMonom(new Monom(3, 1));
        Rez.addMonom(new Monom(1, -10));
        Rez.addMonom(new Monom(0, 2));
        String S1 = Operations.subtractPolynoms(P1, P2).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testMultiplicatePolynoms() {
        Polynom P1 = new Polynom();
        Polynom P2 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(2, 3));
        P1.addMonom(new Monom(1, -1));
        P1.addMonom(new Monom(0, 1));
        P2.addMonom(new Monom(1, 1));
        P2.addMonom(new Monom(0, -2));
        Rez.addMonom(new Monom(3, 3));
        Rez.addMonom(new Monom(2, -7));
        Rez.addMonom(new Monom(1, 3));
        Rez.addMonom(new Monom(0, -2));
        String S1 = Operations.multiplicatePolynoms(P1, P2).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testDivisionQuotientPolynoms() {
        Polynom P1 = new Polynom();
        Polynom P2 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(3, 1));
        P1.addMonom(new Monom(2, -2));
        P1.addMonom(new Monom(1, 6));
        P1.addMonom(new Monom(0, -5));
        P2.addMonom(new Monom(2, 1));
        P2.addMonom(new Monom(0, -1));
        Rez.addMonom(new Monom(1, 1));
        Rez.addMonom(new Monom(0, -2));
        String S1 = Operations.divisionPolynoms(P1, P2).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testDivisionRemainderPolynoms() {
        Polynom P1 = new Polynom();
        Polynom P2 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(3, 1));
        P1.addMonom(new Monom(2, -2));
        P1.addMonom(new Monom(1, 6));
        P1.addMonom(new Monom(0, -5));
        P2.addMonom(new Monom(2, 1));
        P2.addMonom(new Monom(0, -1));
        Rez.addMonom(new Monom(1, 7));
        Rez.addMonom(new Monom(0, -7));
        String S = Operations.divisionPolynoms(P1, P2).toString();
        String S1 = Operations.getDivisionRemainder().toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testDerivativePolynoms() {
        Polynom P1 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(3, 1));
        P1.addMonom(new Monom(2, -2));
        P1.addMonom(new Monom(1, 6));
        P1.addMonom(new Monom(0, -5));
        Rez.addMonom(new Monom(2, 3));
        Rez.addMonom(new Monom(1, -4));
        Rez.addMonom(new Monom(0, 6));
        String S1 = Operations.derivativePolynoms(P1).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }

    @Test
    public void testIntegralPolynoms() {
        Polynom P1 = new Polynom();
        Polynom Rez = new Polynom();
        P1.addMonom(new Monom(3, 1));
        P1.addMonom(new Monom(2, 4));
        P1.addMonom(new Monom(0, 5));
        Rez.addMonom(new Monom(4, (float) 1/4));
        Rez.addMonom(new Monom(3, (float) 4/3));
        Rez.addMonom(new Monom(1, 5));
        String S1 = Operations.integralPolynoms(P1).toString();
        String S2 = Rez.toString();
        System.out.println("Actual: " + S1);
        System.out.println("Expected: " + S2);
        assertTrue("Correct!", S1.equals(S2));
    }
}
