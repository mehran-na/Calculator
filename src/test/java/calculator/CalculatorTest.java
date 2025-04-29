package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final App calculator = new App();

    @Test
    public void testAddition() {
        assertEquals(2.0, calculator.calculate("1+1"));
        assertEquals(3.0, calculator.calculate("1 + 2"));
        assertEquals(0.0, calculator.calculate("1 + -1"));
        assertEquals(0.0, calculator.calculate("-1 - -1"));
        assertEquals(1.0, calculator.calculate("5-4"));
        assertEquals(5.0, calculator.calculate("10/2"));
        assertEquals(8.0, calculator.calculate("4*2"));
        assertEquals(28.0, calculator.calculate("4*4+12"));
        assertEquals(26.5, calculator.calculate("4*4+21/2"));
    }

    @Test
    public void testDivisionByZero() {
        try {
            calculator.calculate("1/0");
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }
}

