package com.andres.alianzabe.service.impl;

import com.andres.alianzabe.domain.User;
import com.andres.alianzabe.dto.UserDto;
import com.andres.alianzabe.exception.NoContentException;
import com.andres.alianzabe.mapper.IUserMapper;
import com.andres.alianzabe.repository.IUserRepository;
import com.andres.alianzabe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<UserDto> getUsers() throws NoContentException {
        return userMapper.entityToDto(userRepository.findAll());
    }

    @Override
    public UserDto getUser(Long id) throws NoContentException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.entityToDto(user.get());
        }
        throw new NoContentException();
    }

    @Override
    public UserDto createUser(UserDto user) {
        User userEntity = userMapper.dtoToEntity(user);
        return userMapper.entityToDto(userRepository.save(userEntity));
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User userEntity = userMapper.dtoToEntity(user);
        return userMapper.entityToDto(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(UserDto user) {
        userRepository.delete(userMapper.dtoToEntity(user));
    }
}
