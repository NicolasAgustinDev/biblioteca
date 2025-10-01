package com.example.library.mapper;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-30T20:51:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        return book;
    }

    @Override
    public BookResponseDTO toDto(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        return bookResponseDTO;
    }

    @Override
    public void updateFromDto(BookRequestDTO dto, Book entity) {
        if ( dto == null ) {
            return;
        }
    }
}
