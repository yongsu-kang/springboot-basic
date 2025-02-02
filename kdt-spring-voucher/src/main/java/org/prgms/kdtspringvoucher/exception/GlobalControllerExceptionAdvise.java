package org.prgms.kdtspringvoucher.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionAdvise {

    private final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionAdvise.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgException(IllegalArgumentException exception) {
        log.error("error message = {}", exception.getMessage());
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String AllException(Exception exception) {
        log.error("error message = {}", exception.getMessage());
        return "index";
    }
}