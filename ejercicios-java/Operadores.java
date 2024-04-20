public class Operadores {

    public static void main(String args[]) {

        // operadores básicos
        int a = 3, b = 2;
        int resultado = a + b;
        System.out.println("Resultado de la suma es = " + resultado);

        resultado = a - b;
        System.out.println("Resultado de la resta es = " + resultado);

        resultado = a * b;
        System.out.println("Resultado de la multiplicación es = " + resultado);

        var resultado2 = 3.0 / b;
        System.out.println("Resultado de la division es = " + resultado2);

        resultado = a % b;
        System.out.println("Resultado del residuo es = " + resultado);

        if (a % 2 == 0)
            System.out.println(a + " es número par");
        else
            System.out.println(a + " es número impar");

        //operadores de asignación
        int aa = 3, bb=2;
        int cc = aa + 5 - bb;
        System.out.println("El resultado es = " + cc);

        aa  += 1;//aa = aa + 1
        System.out.println("El valor es = " + aa); 

        aa += 3;// aa = aa + 3
        System.out.println("El valor es = " + aa);

        aa -= 2;//a = aa - 2
        System.out.println("EL valor es = " + aa);

        aa *= 3;//aa = aa * 3
        System.out.println("El resultado es = " + aa);

        aa /= 3;//aa = aa / 3
        System.out.println("El resultado es = " + aa);

    }

}
