package com.andres.alianzabe.constant;

import org.springframework.http.HttpStatus;

import javax.print.attribute.standard.Severity;

public enum ExceptionErrorEnum {
    USER_NOT_FOUND(Severity.ERROR, "BAASCOSEC000", HttpStatus.BAD_REQUEST, "UserDto not found");

    private String category;
    private String message;
    private Severity severity;
    private HttpStatus httpStatus;

    private ExceptionErrorEnum(Severity severity, String category, HttpStatus httpStatus, String message) {
        this.severity = severity;
        this.httpStatus = httpStatus;
        this.category = category;
        this.message = message;
    }

    public String getCode() {
        String code = this.getSeverity().toString().charAt(0) + "";

        return code + this.getHttpStatus().toString() + this.getCategory();
    }

    public String getMessage() {
        return message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private String getCategory() {
        return category;
    }
}
