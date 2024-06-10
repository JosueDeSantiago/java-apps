package gto.talent.tech;

import gto.tech.talent.address.Address;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia de Address y confirmar que se creó imprimiendo en consola
            Address address = new Address("Zaragoza 276", "Irapuato", "Guanajuato", "36588", "MEX", 1);
            System.out.println("Address instance created: " + address);

            // Verificar que es una instancia de Address e imprimir
            if (address instanceof Address) {
                System.out.println("El objecto en una instancia de: " + address);
            }

            // Imprimir todos los métodos de la clase Address
            Method[] methods = Address.class.getDeclaredMethods();
            System.out.println("Methods of Address class:");
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            // Imprimir todos los parámetros de todos los métodos
            System.out.println("\nParameters of each method:");
            for (Method method : methods) {
                System.out.print(method.getName() + " parameters: ");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            // Cambiar el valor de la propiedad city de la instancia de Address usando el método setCity con reflection
            Method setCityMethod = Address.class.getDeclaredMethod("setCity", String.class);
            setCityMethod.invoke(address, "Leon");
            System.out.println("\nActualizando city usando reflection: " + address.getCity());

            // Imprimir todas las propiedades de Address
            Field[] fields = Address.class.getDeclaredFields();
            System.out.println("\nFields de Address class:");
            for (Field field : fields) {
                field.setAccessible(true);  // Hacer accesible el campo en caso de que sea privado
                System.out.println(field.getName() + " = " + field.get(address));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
