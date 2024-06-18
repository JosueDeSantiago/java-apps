/*
    * TODO: Crear las pruebas unitarias para la clase test.
    *  Cada prueba debe validar un escenario con:
    *  - ambos numeros positivos
    *  - ambos numeros negativos
    *  - un numero positivo y un numero negativo
    *
    * TODO: NOTA: En el caso de la operacion division hay que hacer una validacion extra para la division entre 0
    *  y verificar que se lance la excepcion correcta
    *
    * TODO: Despues de cada prueba, se debe mostrar en consola el mensaje: "pruebas realizadas: "
    *  acompaniado de el numero de validaciones realizadas (3)
*/

package gto.talent.tech.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static int validationCount;

    @BeforeAll
    public static void setup() {
        calculator = new Calculator();
        validationCount = 0;
    }

    @BeforeEach
    public void individualSetup() {
        validationCount = 0;
    }

    @Test
    public void testAdd() {
        // ambos números positivos
        assertEquals(5, calculator.add((short) 2, (short) 3));
        validationCount++;
        
        // ambos números negativos
        assertEquals(-5, calculator.add((short) -2, (short) -3));
        validationCount++;
        
        // un número positivo y un número negativo
        assertEquals(1, calculator.add((short) 3, (short) -2));
        validationCount++;
        
        System.out.println("pruebas realizadas: " + validationCount);
    }

    @Test
    public void testSubtract() {
        // ambos números positivos
        assertEquals(1, Calculator.subtract((short) 3, (short) 2));
        validationCount++;
        
        // ambos números negativos
        assertEquals(1, Calculator.subtract((short) -2, (short) -3));
        validationCount++;
        
        // un número positivo y un número negativo
        assertEquals(5, Calculator.subtract((short) 3, (short) -2));
        validationCount++;
        
        System.out.println("pruebas realizadas: " + validationCount);
    }

    @Test
    public void testMultiply() {
        // ambos números positivos
        assertEquals(6, Calculator.multiply((short) 2, (short) 3));
        validationCount++;
        
        // ambos números negativos
        assertEquals(6, Calculator.multiply((short) -2, (short) -3));
        validationCount++;
        
        // un número positivo y un número negativo
        assertEquals(-6, Calculator.multiply((short) 3, (short) -2));
        validationCount++;
        
        System.out.println("pruebas realizadas: " + validationCount);
    }

    @Test
    public void testDivideSuccess() {
        // ambos números positivos
        assertEquals(2, Calculator.divide((short) 4, (short) 2));
        validationCount++;
        
        // ambos números negativos
        assertEquals(2, Calculator.divide((short) -4, (short) -2));
        validationCount++;
        
        // un número positivo y un número negativo
        assertEquals(-2, Calculator.divide((short) 4, (short) -2));
        validationCount++;
        
        System.out.println("pruebas realizadas: " + validationCount);
    }

    @Test
    public void testDivideByZero() {
        // División por cero
        assertThrows(ArithmeticException.class, () -> Calculator.divide((short) 4, (short) 0));
        validationCount++;
        
        System.out.println("pruebas realizadas: " + validationCount);
    }

    @AfterEach
    public void resetValue() {
        validationCount = 0;
    }
}
