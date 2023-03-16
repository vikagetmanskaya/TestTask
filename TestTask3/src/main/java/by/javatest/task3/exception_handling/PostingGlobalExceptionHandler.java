package by.javatest.task3.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostingGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PostingIncorrectData> handleException(NoSuchPostingException exception){
        PostingIncorrectData incorrectData = new PostingIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<PostingIncorrectData> handleException(Exception exception){
        PostingIncorrectData incorrectData = new PostingIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST );
    }
}
