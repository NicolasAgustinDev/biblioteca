package com.example.library.service.interfaces;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserByUsername(String username);
    UserResponseDTO createUser(UserRequestDTO request);
    UserResponseDTO updateUser(String username, UserRequestDTO request);
    void deleteUser(String username);
}
