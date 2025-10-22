package com.example.library.mapper;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookEntity toEntity(BookRequestDTO dto) {
        return BookEntity.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .year(dto.getYear())
                .totalCopies(dto.getTotalCopies())
                .category(dto.getCategory())
                .build();
    }

    public BookResponseDTO toDTO(BookEntity entity) {
        return BookResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .year(entity.getYear())
                .totalCopies(entity.getTotalCopies())
                .category(entity.getCategory())
                .build();
    }
}
