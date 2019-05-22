package com.andres.alianzabe.exception;

import com.andres.alianzabe.constant.ExceptionErrorEnum;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends RuntimeException implements IException {
    private static final long serialVersionUID = 1;

    private final ExceptionErrorEnum error;

    public ServiceException(ExceptionErrorEnum error) {
        this.error = error;
    }

    private static Map<String, Object> errorMap(String path) {
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("Path", path);

        return metadata;
    }

    public ExceptionErrorEnum getError() {
        return this.error;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }

    @Override
    public String getMessagePersonal() {
        return null;
    }
}