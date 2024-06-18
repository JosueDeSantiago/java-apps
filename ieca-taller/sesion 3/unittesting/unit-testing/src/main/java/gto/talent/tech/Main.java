package gto.talent.tech;

import gto.talent.tech.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Add: " + Calculator.add((short) 10, (short) 20));
        System.out.println("Subtract: " + Calculator.subtract((short) 10, (short) 5));
        System.out.println("Multiply: " + Calculator.multiply((short) 10, (short) 5));
        try {
            System.out.println("Divide: " + Calculator.divide((short) 10, (short) 0));
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
