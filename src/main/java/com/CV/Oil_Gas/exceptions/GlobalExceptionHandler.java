package com.CV.Oil_Gas.exceptions;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.stream.Collectors;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) ResponseEntity<ErrorResponse> notFound(ResourceNotFoundException e){return build(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler({BadRequestException.class,IllegalArgumentException.class}) ResponseEntity<ErrorResponse> bad(RuntimeException e){return build(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException e){String m=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).collect(Collectors.joining(", "));return build(HttpStatus.BAD_REQUEST,m);}
 @ExceptionHandler(Exception.class) ResponseEntity<ErrorResponse> generic(Exception e){return build(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected server error");}
 private ResponseEntity<ErrorResponse> build(HttpStatus s,String m){return ResponseEntity.status(s).body(new ErrorResponse(s.value(),s.getReasonPhrase(),m,LocalDateTime.now()));}
}