package model;

public class Monom {
    private int exponent;
    private int coeficient;
    private float coeficientIntegral;

    public Monom(int exponent, int coeficient) {
        if(exponent < 0) {
            throw new IllegalArgumentException("The exponent can't be negative! Exponent: " + exponent);
        }
        this.exponent = exponent;
        this.coeficient = coeficient;
        this.coeficientIntegral = 1;
    }

    public Monom(int exponent, float coeficientIntegral) {
        if(exponent < 0) {
            throw new IllegalArgumentException("The exponent can't be negative! Exponent: " + exponent);
        }
        this.exponent = exponent;
        this.coeficient = 1;
        this.coeficientIntegral = coeficientIntegral;
    }

    public int getExponent() {
        return exponent;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public float getCoeficientIntegral() {
        return coeficientIntegral;
    }
}