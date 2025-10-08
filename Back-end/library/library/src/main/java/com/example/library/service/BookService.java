package com.example.library.service;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO create(BookRequestDTO bookDto);
    BookResponseDTO update(Long bookId, BookRequestDTO bookDto);
    BookResponseDTO findById(Long bookId);
    List<BookResponseDTO> list();
    void delete(Long bookId);
}
