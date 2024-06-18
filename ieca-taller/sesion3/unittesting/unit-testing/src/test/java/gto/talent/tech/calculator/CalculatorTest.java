package gto.talent.tech.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        System.out.println("crear instancia de calculator");
        calculator = new Calculator();
    }

    @BeforeEach
    public void individualSetup(){
        System.out.println("este se ejecuta muchas veces");
    }

    @Test
    public void testAddPositive(){
        Assertions.assertEquals((short) 5, calculator.add((short)2,(short)3));
    }

    @Test
    public void testAddNegative(){
        Assertions.assertEquals((short) -1, calculator.add((short)2,(short)-3));
    }

    @Test
    public void testSubtract(){
        Assertions.assertEquals((short)5, Calculator.subtract((short)6,(short)1));

    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals((short)6, Calculator.multiply((short)2,(short)3));
    }

    @Test
    public void testDivideSuccess(){
        short expected = Calculator.divide((short)10,(short)2);
        Assertions.assertEquals((short)5, expected);
    }

    @Test
    public void testDivideByZero(){
        Exception aritmeticException = assertThrows(ArithmeticException.class, () -> Calculator.divide((short)2,(short)0));
        Assertions.assertEquals("/ by zero", aritmeticException.getMessage());
    }

    @AfterAll
    public static void closeConnTest(){
        System.out.println("imagino que cierro una conexion de un NIO");
    }

    @AfterEach
    public void cleanStatusTest(){
        System.out.println("imagino que limpio una lista");
    }
}
