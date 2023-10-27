package ue.kat.imageHolder.imageHolder.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ue.kat.imageHolder.imageHolder.dto.error.ErrorResponse;
import ue.kat.imageHolder.imageHolder.exception.BadRequestException;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ControllerExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BadRequestException.class)
  @ResponseBody
  ErrorResponse handleBadRequestException(BadRequestException e) {
    return new ErrorResponse(e.getMessage());
  }
}
