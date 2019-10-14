package com.lambdaschool.school.handlers;

import com.lambdaschool.school.exceptions.ResourceNotFoundException;
import com.lambdaschool.school.model.ErrorDetail;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
  public RestExceptionHandler()
  {
    super();
  }

  // handle resource not found exception
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(Exception rnfe, HttpServletRequest request)
  {
    ErrorDetail errorDetail = new ErrorDetail();

    errorDetail.setTimestamp(new Date().getTime());
    errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
    errorDetail.setTitle("Resource not found");
    errorDetail.setDetail(rnfe.getMessage());
    errorDetail.setDevelopermessage(rnfe.getClass().getName());

    return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
  }
}
