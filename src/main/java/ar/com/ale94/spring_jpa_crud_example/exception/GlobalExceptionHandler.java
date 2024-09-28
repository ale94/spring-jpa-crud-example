package ar.com.ale94.spring_jpa_crud_example.exception;

import ar.com.ale94.spring_jpa_crud_example.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerIdNotFoundException(IdNotFoundException ex,
                                                               WebRequest request) {
        ErrorDTO error = new ErrorDTO(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
