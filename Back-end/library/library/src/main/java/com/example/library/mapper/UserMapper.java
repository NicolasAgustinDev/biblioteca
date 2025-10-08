package com.example.library.mapper;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;
import com.example.library.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(UserRequestDTO userDto) {
        if (userDto == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setUserPassword(userDto.getUserPassword());
        userEntity.setUserFullName(userDto.getUserFullName());
        userEntity.setUserEnabled(true);
        return userEntity;
    }

    public UserResponseDTO toDto(UserEntity userEntity) {
        if (userEntity == null) return null;

        UserResponseDTO userDto = new UserResponseDTO();
        userDto.setUsername(userEntity.getUsername());
        userDto.setUserFullName(userEntity.getUserFullName());
        userDto.setUserEnabled(userEntity.getUserEnabled());
        userDto.setUserCreatedAt(userEntity.getUserCreatedAt());
        return userDto;
    }
}
