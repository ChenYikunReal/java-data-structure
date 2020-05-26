package org.structures.list.polynomial;

public class PolynomialTester {

    public static void main(String[] args) {
        String[] initialA = {"3,0", "3,1", "3,4"};
        String[] initialB = {"3,0", "3,2", "3,3", "4,7"};
        
        Polynomial polynomial = new Polynomial();
        PolynomialList list = polynomial.addPolynomial(initialA, initialB);
        list.printpolynomial();
    }

}
