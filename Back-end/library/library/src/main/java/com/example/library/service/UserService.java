package com.example.library.service;

import com.example.library.dto.UserRequestDTO;
import com.example.library.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);
    UserResponseDTO update(Long id, UserRequestDTO dto);
    UserResponseDTO findById(Long id);
    List<UserResponseDTO> list();
    void delete(Long id);
}
