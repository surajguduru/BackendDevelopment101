package dev.suraj.productservice.ExceptionHandlers;

import dev.suraj.productservice.DTOs.ExceptionDTO;
import dev.suraj.productservice.Exceptions.ProductNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException(ArithmeticException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Arithmetic Exception Occurred", "Please check the input values");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Array Index Out Of Bounds Exception Occurred", "Please check the array size and index");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralExceptions(Exception e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("General Exception Occurred", "Please check the input values");
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO, org.springframework.http.HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Product Not Found Exception Occurred", e.getMessage());
        ResponseEntity<ExceptionDTO> responseEntity = new ResponseEntity<>(exceptionDTO, org.springframework.http.HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
