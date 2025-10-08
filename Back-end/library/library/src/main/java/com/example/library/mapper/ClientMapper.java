package com.example.library.mapper;

import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;
import com.example.library.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientEntity toEntity(ClientRequestDTO clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientName(clientDto.getClientName());
        clientEntity.setClientEmail(clientDto.getClientEmail());
        clientEntity.setClientPhone(clientDto.getClientPhone());
        clientEntity.setClientAddress(clientDto.getClientAddress());
        return clientEntity;
    }

    public ClientResponseDTO toDTO(ClientEntity clientEntity) {
        ClientResponseDTO clientDto = new ClientResponseDTO();
        clientDto.setClientId(clientEntity.getClientId());
        clientDto.setClientName(clientEntity.getClientName());
        clientDto.setClientEmail(clientEntity.getClientEmail());
        clientDto.setClientPhone(clientEntity.getClientPhone());
        clientDto.setClientAddress(clientEntity.getClientAddress());
        clientDto.setClientCreatedAt(clientEntity.getCreatedAt());
        return clientDto;
    }
}
