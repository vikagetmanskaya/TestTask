package by.javatest.task2.service;

import by.javatest.task2.exception.FactorialException;

public interface Calculator {
    int getFactorial(int num) throws FactorialException;
    double expressionCalculator(int n) throws FactorialException;
}
