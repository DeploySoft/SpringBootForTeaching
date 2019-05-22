package com.andres.alianzabe.delegate;

import com.andres.alianzabe.dto.ResponseData;
import com.andres.alianzabe.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface IDelegateController {


    public ResponseEntity createUser(UserDto userDto);

    public ResponseEntity updateUser(Long id, UserDto userDto);

    public ResponseEntity deleteUser(Long id);

    public ResponseEntity getUser(Long id);

    public ResponseEntity<ResponseData> getUsers();


}
