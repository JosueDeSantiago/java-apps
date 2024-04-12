//programa que recibe dos números y muestra la suma
public class Suma {
    //el metodo main empieza la ejecución de la aplicación en Java
    public static void main (String[] args)
    {
        int numero1; //primer número a sumar
        int numero2; //segundo número a sumar
        int suma; //suma de numero1 y numero2

        System.out.print("Escriba el primer entero: "); //indicador
        numero1 = Integer.parseInt(System.console().readLine()); //lee el primer número del usuario

        System.out.print("Escriba el segundo entero: "); //indicador
        numero2 = Integer.parseInt(System.console().readLine()); //lee el segundo número del usuario

        suma = numero1 + numero2; //suma los dos números, después almacena el total en suma

        System.out.printf("La suma es %d%n", suma); //muestra la suma
    }//fin del metodo main
}//fin de la clase Suma
