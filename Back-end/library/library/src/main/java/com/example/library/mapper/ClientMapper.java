package com.example.library.mapper;

import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;
import com.example.library.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientEntity toEntity(ClientRequestDTO dto) {
        return ClientEntity.builder()
                            .name(dto.getName())
                            .email(dto.getEmail())
                            .phone(dto.getPhone())
                            .address(dto.getAddress())
                            .build();
    }

    public ClientResponseDTO toDTO(ClientEntity entity) {
        return ClientResponseDTO.builder()
                .email(entity.getEmail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .build();
    }
}
