package com.example.library.mapper;


import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;
import com.example.library.entity.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequestDTO dto);
    ClientResponseDTO toDto(Client entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ClientRequestDTO dto, @MappingTarget Client entity);
}
