package model;
import java.util.ArrayList;
import java.util.HashMap;

public class Operations {
    private static Polynom divisionRemainder;

    public static Polynom addPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
        HashMap<Integer, Integer> addResult = new HashMap<Integer, Integer>();
        for (Monom monom : firstPolynom.getPolynom()) {
            addResult.put(monom.getExponent(), monom.getCoeficient());
        }
        for (Monom monom : secondPolynom.getPolynom()) {
            int searchingExponent = monom.getExponent();
            if (addResult.containsKey(searchingExponent)) {
                addResult.replace(searchingExponent, addResult.get(searchingExponent), addResult.get(searchingExponent) + monom.getCoeficient());
            } else {
                addResult.put(monom.getExponent(), monom.getCoeficient());
            }
        }
        Polynom result = new Polynom();
        addResult.forEach((exponent, coeficient) -> {
            Monom intermediateMonom = new Monom(exponent, coeficient);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom subtractPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
        HashMap<Integer, Integer> substractResult = new HashMap<Integer, Integer>();
        for (Monom monom : firstPolynom.getPolynom()) {
            substractResult.put(monom.getExponent(), monom.getCoeficient());
        }
        for (Monom monom : secondPolynom.getPolynom()) {
            int searchingExponent = monom.getExponent();
            if (substractResult.containsKey(searchingExponent)) {
                substractResult.replace(searchingExponent, substractResult.get(searchingExponent), substractResult.get(searchingExponent) - monom.getCoeficient());
            } else {
                substractResult.put(monom.getExponent(), (-1) * monom.getCoeficient());
            }
        }
        Polynom result = new Polynom();
        substractResult.forEach((exponent, coeficient) -> {
            Monom intermediateMonom = new Monom(exponent, coeficient);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom multiplicatePolynoms(Polynom firstPolynom, Polynom secondPolynom) {
        HashMap<Integer, Integer> multiplicateResult = new HashMap<Integer, Integer>();
        for (Monom monom1 : firstPolynom.getPolynom()) {
            for (Monom monom2 : secondPolynom.getPolynom()) {
                Monom intermediateMonom = new Monom(monom1.getExponent() + monom2.getExponent(), monom1.getCoeficient() * monom2.getCoeficient());
                int searchingExponent = intermediateMonom.getExponent();
                if (multiplicateResult.containsKey(searchingExponent)) {
                    multiplicateResult.replace(searchingExponent, multiplicateResult.get(searchingExponent), multiplicateResult.get(searchingExponent) + intermediateMonom.getCoeficient());
                } else {
                    multiplicateResult.put(intermediateMonom.getExponent(), intermediateMonom.getCoeficient());
                }
            }
        }
        Polynom result = new Polynom();
        multiplicateResult.forEach((exponent, coeficient) -> {
            Monom intermediateMonom = new Monom(exponent, coeficient);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom derivativePolynoms(Polynom onePolynom) {
        HashMap<Integer, Integer> derivativeResult = new HashMap<Integer, Integer>();
        for (Monom monom : onePolynom.getPolynom()) {
            Monom intermediateMonom;
            if(monom.getExponent() == 0) {
                intermediateMonom = new Monom(0, 0);
            } else {
                intermediateMonom = new Monom(monom.getExponent() - 1, monom.getExponent() * monom.getCoeficient());
            }
            int searchingExponent = intermediateMonom.getExponent();
            if (derivativeResult.containsKey(searchingExponent)) {
                derivativeResult.replace(searchingExponent, derivativeResult.get(searchingExponent), derivativeResult.get(searchingExponent) + intermediateMonom.getCoeficient());
            } else {
                if(monom.getExponent() == 0) {
                    derivativeResult.put(monom.getExponent(), monom.getExponent() * monom.getCoeficient());
                } else {
                    derivativeResult.put(monom.getExponent() - 1, monom.getExponent() * monom.getCoeficient());
                }
            }
        }
        Polynom result = new Polynom();
        derivativeResult.forEach((exponent, coeficient) -> {
            Monom intermediateMonom = new Monom(exponent, coeficient);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom integralPolynoms(Polynom onePolynom) {
        HashMap<Integer, Float> integralResult = new HashMap<Integer, Float>();
        for (Monom monom : onePolynom.getPolynom()) {
            Monom intermediateMonom = new Monom(monom.getExponent() + 1, (float) monom.getCoeficient() / (float) (monom.getExponent() + 1));
            int searchingExponent = intermediateMonom.getExponent();
            if (integralResult.containsKey(searchingExponent)) {
                integralResult.replace(searchingExponent, integralResult.get(searchingExponent), integralResult.get(searchingExponent) + intermediateMonom.getCoeficientIntegral());
            } else {
                integralResult.put(monom.getExponent() + 1, (float) monom.getCoeficient() / (float) (monom.getExponent() + 1));
            }
        }
        Polynom result = new Polynom();
        integralResult.forEach((exponent, coeficientIntegral) -> {
            Monom intermediateMonom = new Monom(exponent, coeficientIntegral);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom divisionPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
        HashMap<Integer, Integer> divisionResult = new HashMap<Integer, Integer>();
        if(firstPolynom.getPolynom().get(0).getExponent() < secondPolynom.getPolynom().get(0).getExponent()) {
            ArrayList<Monom> intermediateList = secondPolynom.getPolynom();
            secondPolynom = new Polynom(firstPolynom.getPolynom());
            firstPolynom = new Polynom(intermediateList);
        }
        int i = 0;
        while(firstPolynom.getPolynom().get(i).getExponent() >= secondPolynom.getPolynom().get(0).getExponent()) {
            Monom intermediateMonom = new Monom(firstPolynom.getPolynom().get(i).getExponent() - secondPolynom.getPolynom().get(0).getExponent(), firstPolynom.getPolynom().get(i).getCoeficient() / secondPolynom.getPolynom().get(0).getCoeficient());
            int searchingExponent = intermediateMonom.getExponent();
            if (divisionResult.containsKey(searchingExponent)) {
                divisionResult.replace(searchingExponent, divisionResult.get(searchingExponent), divisionResult.get(searchingExponent) + intermediateMonom.getCoeficient());
            } else {
                divisionResult.put(intermediateMonom.getExponent(), intermediateMonom.getCoeficient());
            }
            Polynom intermediatePolynom = new Polynom();
            intermediatePolynom.addMonom(intermediateMonom);
            firstPolynom = subtractPolynoms(firstPolynom, multiplicatePolynoms(secondPolynom, intermediatePolynom));
            i++;
        }
        divisionRemainder = new Polynom();
        for (Monom monom : firstPolynom.getPolynom()) {
            if(monom.getCoeficient() != 0) {
                divisionRemainder.addMonom(monom);
            }
        }
        Polynom result = new Polynom();
        divisionResult.forEach((exponent, coeficient) -> {
            Monom intermediateMonom = new Monom(exponent, coeficient);
            result.addMonom(intermediateMonom);
        });
        return result;
    }

    public static Polynom getDivisionRemainder() {
        return divisionRemainder;
    }
}
