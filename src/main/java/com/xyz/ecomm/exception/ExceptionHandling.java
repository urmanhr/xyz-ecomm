/*
 * package com.xyz.ecomm.exception;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler;
 * 
 * @ControllerAdvice public class ExceptionHandling {
 * 
 * @ExceptionHandler(value = ProductNotfoundException.class) public
 * ResponseEntity<ProductNotfoundException> exception(ProductNotfoundException
 * exception) { return new ResponseEntity<ProductNotfoundException>(new
 * ProductNotfoundException(), HttpStatus.NOT_FOUND); }
 * 
 * @ExceptionHandler(value = Exception.class) public ResponseEntity<Object>
 * exception(Exception exception) { return new
 * ResponseEntity<>("Unknown Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
 * } }
 */