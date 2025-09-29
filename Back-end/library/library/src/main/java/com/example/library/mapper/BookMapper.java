package com.example.library.mapper;

import com.example.library.dto.BookResponseDTO;
import com.example.library.dto.BookRequestDTO;
import com.example.library.entity.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookRequestDTO dto);
    BookResponseDTO toDto(Book entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(BookRequestDTO dto, @MappingTarget Book entity);
}
