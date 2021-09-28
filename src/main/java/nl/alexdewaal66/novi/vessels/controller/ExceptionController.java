package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.exceptions.UsernameNotFoundException;
import nl.alexdewaal66.novi.vessels.exceptions.UsernameExistsException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
@CrossOrigin(origins = {"*"})
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception(BadRequestException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Object> exception(UsernameNotFoundException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = UsernameExistsException.class)
    public ResponseEntity<Object> exception(UsernameExistsException exception) {
        return ResponseEntity.badRequest().build();
    }

    //

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        System.out.println(" -----> message = " + message);
        return ResponseEntity.badRequest().body(message);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set<String>> handleConstraintViolation(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        Set<String> messages = new HashSet<>(constraintViolations.size());
        messages.addAll(constraintViolations.stream()
                .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
                        constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
                .collect(Collectors.toList()));

        return ResponseEntity.badRequest().body(messages);

    }

@ExceptionHandler(value = IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<Object> exception(IncorrectResultSizeDataAccessException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage().split(":")[0]);
}
}
