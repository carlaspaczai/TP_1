package model;
import java.util.ArrayList;
import java.util.Comparator;

public class Polynom {
    private ArrayList<Monom> polynom;

    public Polynom() {
        this.polynom = new ArrayList<Monom>();
    }

    public Polynom(ArrayList<Monom> polynom) {
        this.polynom = polynom;
    }

    public ArrayList<Monom> getPolynom() {
        return polynom;
    }

    public void addMonom(Monom intermediateMonom) {
        this.polynom.add(intermediateMonom);
        this.polynom.sort(new Comparator<Monom>() {
            @Override
            public int compare(Monom o1, Monom o2) {
                if(o1.getExponent() == o2.getExponent()){
                    return 0;
                } else if(o1.getExponent() > o2.getExponent()) {
                    return -1;
                }
                return 1;
            }
        });
    }

    @Override
    public String toString() {
        String intermediateString = "";
        boolean firstElement = true;
        for(Monom intermediateMonom : this.getPolynom()) {
            if(firstElement == false && intermediateMonom.getCoeficient() > 0 && intermediateMonom.getCoeficientIntegral() > 0) {
                intermediateString += "+";
            }
            if(intermediateMonom.getCoeficient() != 0 && intermediateMonom.getCoeficientIntegral() != 0) {
                if(intermediateMonom.getCoeficientIntegral() == 1) {
                    intermediateString += intermediateMonom.getCoeficient() + "X^" + intermediateMonom.getExponent();
                } else {
                    if(intermediateMonom.getCoeficientIntegral() == (int)intermediateMonom.getCoeficientIntegral()) {
                        intermediateString += (int)intermediateMonom.getCoeficientIntegral() + "X^" + intermediateMonom.getExponent();
                    } else {
                        intermediateString += intermediateMonom.getCoeficientIntegral() + "X^" + intermediateMonom.getExponent();
                    }
                }
                firstElement = false;
            }
        }
        return intermediateString;
    }


}