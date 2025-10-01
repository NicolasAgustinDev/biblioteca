package com.example.library.service;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO create(BookRequestDTO dto);
    BookResponseDTO update(Long id, BookRequestDTO dto);
    BookResponseDTO findById(Long id);
    List<BookResponseDTO> list();
    void delete(Long id);
}
