package by.javatest.task2.service.impl;

import by.javatest.task2.exception.FactorialException;
import by.javatest.task2.service.Calculator;

public class CalculatorImpl implements Calculator {
    public int getFactorial(int num) throws FactorialException {
        int result = 1;
        if (num < 1) {
            throw new FactorialException("The number is less than 1");
        }

        for (int i = 1; i <= num; i++) {
            result = result * i;
        }

        return result;
    }

    public double expressionCalculator(int n) throws FactorialException {

        double firstMultiplier = (1 / (double) getFactorial(n));

        double secondMultiplier = 0;
        for (int i = 1; i <= n; i++) {

            secondMultiplier += getFactorial(i);

        }
        double un = firstMultiplier * secondMultiplier;
        return un;
    }
}
