package com.andres.alianzabe.exception;

import org.springframework.http.HttpStatus;

public interface IException {

    HttpStatus getStatus();

    String getMessagePersonal();
}
