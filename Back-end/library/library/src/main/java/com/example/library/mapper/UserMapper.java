package com.example.library.mapper;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;
import com.example.library.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        return UserEntity.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .password(dto.getPassword())
                .createdAt(dto.getCreatedAt())
                .enabled(true)
                .build();

    }

    public UserResponseDTO toDto(UserEntity entity) {
        if (entity == null) return null;

        return UserEntity.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .enabled(entity.getEnabled())
                .createdAt(entity.getCreatedAt())
                .password(entity.getPassword())
                .build();
    }
}
