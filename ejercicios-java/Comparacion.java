 public class Comparacion { 
    //el metodo main empieza la ejecución de la aplicacion en Java    
    public static void main(String [] args)
    {
        int numero1; //primer número a comparar
        int numero2; //segundo número a comparar

        System.out.print("Escriba el primer entero: "); //indicador
        numero1 = Integer.parseInt(System.console().readLine()); //lee el primer número del usuario

        System.out.print("Escriba el segundo entero: "); //indicador
        numero2 = Integer.parseInt(System.console().readLine()); //lee el segundo número del usuario

        if (numero1 == numero2)
            System.out.printf("%d == %d%n", numero1, numero2);

        if (numero1 != numero2)
            System.out.printf("%d != %d%n", numero1, numero2);

        if (numero1 < numero2)
            System.out.printf("%d < %d%n", numero1, numero2);
        
        if (numero1 > numero2)
            System.out.printf("%d > %d%n", numero1, numero2);

        if (numero1 <= numero2)
            System.out.printf("%d <= %d%n", numero1, numero2);

        if (numero1 >= numero2)
            System.out.printf("%d >= %d%n", numero1, numero2);
    } //fin del metodo main
} //fin de la clase
