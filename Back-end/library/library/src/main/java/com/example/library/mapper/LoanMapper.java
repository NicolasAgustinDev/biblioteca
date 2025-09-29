package com.example.library.mapper;

import com.example.library.dto.LoanRequestDTO;
import com.example.library.dto.LoanResponseDTO;
import com.example.library.entity.Loan;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface LoanMapper {

    // RequestDTO → Entity
    @Mapping(target = "book.id", source = "bookId")
    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "user.id", source = "userId")
    Loan toEntity(LoanRequestDTO dto);

    // Entity → ResponseDTO
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "userId", source = "user.id")
    LoanResponseDTO toDto(Loan entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(LoanRequestDTO dto, @MappingTarget Loan entity);
}
