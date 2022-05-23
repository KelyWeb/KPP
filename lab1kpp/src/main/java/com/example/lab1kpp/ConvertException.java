package com.example.lab1kpp;
import org.springframework.http.HttpStatus;

public class ConvertException extends Exception {
    private String exception;
    private HttpStatus status;

    public ConvertException(String exception, HttpStatus status) {

        this.exception = exception;
        this.status = status;

    }
    public ConvertException(String exception) {

        this.exception = exception;

    }
    public String getException() {

        return this.exception;

    }
    public void setException(String exception) {

        this.exception = exception;

    }
    public HttpStatus getStatus() {

        return this.status;

    }
    public void setStatus(HttpStatus status) {

        this.status = status;

    }

}
