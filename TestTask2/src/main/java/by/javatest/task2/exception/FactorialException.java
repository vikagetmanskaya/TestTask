package by.javatest.task2.exception;

public class FactorialException extends Exception{
    public FactorialException() {
        super();
    }

    public FactorialException(String message) {
        super(message);
    }

    public FactorialException(Exception e) {
        super(e);
    }

    public FactorialException(String message, Exception e) {
        super(message, e);
    }
}
