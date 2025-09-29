package com.example.library.mapper;

import com.example.library.dto.ClientRequestDTO;
import com.example.library.dto.ClientResponseDTO;
import com.example.library.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-29T01:16:57-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        return client;
    }

    @Override
    public ClientResponseDTO toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        return clientResponseDTO;
    }

    @Override
    public void updateFromDto(ClientRequestDTO dto, Client entity) {
        if ( dto == null ) {
            return;
        }
    }
}
