package com.andres.alianzabe.delegate.impl;

import com.andres.alianzabe.delegate.IDelegateController;
import com.andres.alianzabe.dto.MetaData;
import com.andres.alianzabe.dto.ResponseData;
import com.andres.alianzabe.dto.UserDto;
import com.andres.alianzabe.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DelegateController implements IDelegateController {


    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity createUser(UserDto userDto) {
        log.debug("USUARIO CREADO");
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateUser(Long id, UserDto userDto) {
        log.debug("USUARIO ACTUALIZADO", id);
        UserDto user = userService.getUser(id);
        if (user != null) {
            userService.updateUser(userDto);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        log.debug("USUARIO ELIMINADO", id);
        UserDto user = userService.getUser(id);
        if (user != null) {
            userService.deleteUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity getUser(Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> getUsers() {
        return new ResponseEntity<>(new ResponseData(new MetaData(100), userService.getUsers()), HttpStatus.OK);
    }




}