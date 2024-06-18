package gto.talent.tech.calculator;

public class Calculator {
    public short add(short a, short b){
        return (short) (a + b);
    }

    public static short subtract(short a, short b){
        return (short) (a - b);
    }

    public static short multiply(short a, short b){
        return (short) (a * b);
    }

    public static short divide(short a, short b) throws ArithmeticException{
        /*
        if(b == 0){
            throw new ArithmeticException("Division by zero");
        }else{
            return (short) (a / b);
        }
         */
        return (short) (a / b);
    }
}