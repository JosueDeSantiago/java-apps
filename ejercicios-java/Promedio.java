public class Promedio {
//el metodo main empieza la ejecución de la aplicación Java
    public static void main (String[] args)
    {
        System.out.println("¿Cuántos números piensas decirme?");
        int a = Integer.parseInt(System.console().readLine());
        int i=0, s=0;

        while (i < a){
            System.out.println("Dime un número");
            int n = Integer.parseInt(System.console().readLine());
            s = s + n;
            i = i + 1;
        }
        float media = s / a;
        System.out.println("La media vale: " + media);        
    }    
}