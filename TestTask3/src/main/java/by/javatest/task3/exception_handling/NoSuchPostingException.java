package by.javatest.task3.exception_handling;

public class NoSuchPostingException extends RuntimeException{
    public NoSuchPostingException(String message) {
        super(message);
    }
}
