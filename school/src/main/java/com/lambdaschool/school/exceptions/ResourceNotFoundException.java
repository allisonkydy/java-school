package com.lambdaschool.school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
  public ResourceNotFoundException(String message)
  {
    super(message + " is not a valid resource. Please try again.");
  }

  public ResourceNotFoundException(String message, Throwable cause)
  {
    super(message + " is not a valid resource. Please try again.", cause);
  }
}
