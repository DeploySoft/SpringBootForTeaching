package com.andres.alianzabe.service;


import com.andres.alianzabe.domain.User;
import com.andres.alianzabe.dto.UserDto;
import com.andres.alianzabe.exception.NoContentException;

import java.util.List;


public interface IUserService {

    List<UserDto> getUsers() throws NoContentException;

    UserDto getUser(Long id) throws NoContentException;

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user);

    void deleteUser(UserDto user);

}
