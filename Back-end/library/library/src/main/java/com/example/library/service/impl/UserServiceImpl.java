package com.example.library.service.impl;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;
import com.example.library.entity.UserEntity;
import com.example.library.exceptions.UserNotFoundException;
import com.example.library.mapper.UserMapper;
import com.example.library.repository.UserRepository;
import com.example.library.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        UserEntity userEntity = userMapper.toEntity(request);
        return userMapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public UserResponseDTO updateUser(String username, UserRequestDTO request) {
        UserEntity userExisting = userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        userExisting.setUserFullName(request.getUserFullName());
        userExisting.setUserPassword(request.getUserPassword());
        return userMapper.toDto(userRepository.save(userExisting));
    }

    @Override
    public void deleteUser(String username) {
        if (!userRepository.existsById(username)) {
            throw new UserNotFoundException(username);
        }
        userRepository.deleteById(username);
    }
}
