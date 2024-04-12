public class TiposBoolean {

    public static void main (String args []){

        boolean  varBoolean = true;
        System.out.println("Valor de la variable = " + varBoolean);

        if(varBoolean == true){
            System.out.println("La bandera es verdadera");
        } else {
            System.out.println("La bandera es falsa");
        }

        var edad = 10; 
        var esAdulto = edad >= 18; 

        if(esAdulto){
            System.out.println("eres mayor de edad");
        } else {
            System.out.println("eres menor de edad");
        }

    }
    
}
