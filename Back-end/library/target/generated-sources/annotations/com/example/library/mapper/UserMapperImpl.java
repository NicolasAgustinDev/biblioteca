package com.example.library.mapper;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;
import com.example.library.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-01T00:48:30-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserResponseDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return userResponseDTO;
    }

    @Override
    public void updateFromDto(UserRequestDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }
    }
}
