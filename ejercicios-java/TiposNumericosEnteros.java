import javax.print.attribute.SupportedValuesAttribute;

public class TiposNumericosEnteros {

    public static void main (String args []) {

        byte numeroByte = (byte) 127;
        System.out.println("***");
        System.out.println("Valor de la variable de tipo byte: " + numeroByte);
        System.out.println("Valor minimo del tipo de dato byte: " + Byte.MIN_VALUE);
        System.out.println("Valor maximo del tipo de dato byte: " + Byte.MAX_VALUE);
        System.out.println("***");

        short numeroShort = (short) 32767;
        System.out.println("Valor de la variable de tipo short: " + numeroShort);
        System.out.println("Valor minimo del tipo de dato short: " + Short.MIN_VALUE);
        System.out.println("Valor maximo del tipo de dato short: " + Short.MAX_VALUE);
        System.out.println("***");

        int numeroEntero = (int) 2147483647;
        System.out.println("Valor de la variable de tipo int: " + numeroEntero);
        System.out.println("Valor minimo del tipo de dato int: " + Integer.MIN_VALUE);
        System.out.println("Valor maximo del tipo de datos int: " + Integer.MAX_VALUE);
        System.out.println("***");

        long numeroLong = (long) 9223372036854775807L;
        System.out.println("Valor de la variable de tipo long: " + numeroLong);
        System.out.println("Valor minimo del tipo de datos long: " + Long.MIN_VALUE);
        System.out.println("Valor maximo del tipo de datos long: " + Long.MAX_VALUE);
        System.out.println("***");                      

    }
    
}
