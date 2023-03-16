package by.javatest.task2.main;

import by.javatest.task2.exception.FactorialException;
import by.javatest.task2.service.Calculator;
import by.javatest.task2.service.impl.CalculatorImpl;

public class Main {
    public static void main(String[] args) throws FactorialException {
        Calculator calculator = new CalculatorImpl();
        double result = calculator.expressionCalculator(7);
        System.out.println(result);
    }
}
