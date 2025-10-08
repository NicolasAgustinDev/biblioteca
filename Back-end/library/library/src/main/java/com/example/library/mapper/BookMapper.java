package com.example.library.mapper;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookEntity toEntity(BookRequestDTO bookDto) {
        return BookEntity.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .year(bookDto.getYear())
                .totalCopies(bookDto.getTotalCopies())
                .category(bookDto.getCategory())
                .build();
    }

    public BookResponseDTO toDTO(BookEntity bookEntity) {
        return BookResponseDTO.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .isbn(bookEntity.getIsbn())
                .year(bookEntity.getYear())
                .totalCopies(bookEntity.getTotalCopies())
                .category(bookEntity.getCategory())
                .build();
    }
}
