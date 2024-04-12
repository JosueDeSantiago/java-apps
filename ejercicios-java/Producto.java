//programa que calcula e imprime el producto de tres enteros
public class Producto {
    //el metodo main inicia la ejecución de la aplicación java
    public static void main(String[] args)
    {
        int numero1; //primer número
        int numero2; //segundo número
        int numero3; //tercer número
        int resultado; 

        System.out.print("Escriba el primer entero: ");
        numero1 = Integer.parseInt(System.console().readLine()); //lee el primer número

        System.out.print("Escriba el segundo entero: ");
        numero2 = Integer.parseInt(System.console().readLine()); //lee el segundo número

        System.out.print("Escriba el tercer entero: ");
        numero3 = Integer.parseInt(System.console().readLine()); //lee el tercer entero

        resultado = numero1 * numero2 * numero3; 

        System.out.printf("El producto es %d%n", resultado);

    }
    
}
