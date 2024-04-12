public class Variables {
    public static void main (String args[]){
        int miVariableEntera = 10;
        System.out.println ("el valor es: " + miVariableEntera);
        // modificamos el valor de la variable
        miVariableEntera = 5; 
        System.out.println("el valor es: " + miVariableEntera);

        String miVariableCadena = "Saludos";
        System.out.println(miVariableCadena);

        miVariableCadena = "Adios";
        System.out.println(miVariableCadena);

        //var - Inferencia de tipos en Java
        var miVariableEntera2 = 20; 
        System.out.println(miVariableEntera2);

        var miVariableCadena2 = "Ya me voy";
        System.out.println(miVariableCadena2);    

    }
}
