package by.javatest.task2;

import by.javatest.task2.exception.FactorialException;
import by.javatest.task2.service.Calculator;
import by.javatest.task2.service.impl.CalculatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator = new CalculatorImpl();
    @Test
    public void testGetFactorial() throws FactorialException {
        int number = 5;
        int actual = calculator.getFactorial(number);
        int expected = 120;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testExpressionCalculator() throws FactorialException {
        int number = 25;
        double actual = calculator.expressionCalculator(number);
        double expected = 2.4120573530293474;
        Assert.assertEquals(actual, expected);

    }
}
