package com.example.library.service;

import com.example.library.dto.BookRequestDTO;
import com.example.library.dto.BookResponseDTO;
import com.example.library.entity.Book;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repo;
    private final BookMapper mapper;

    public BookServiceImpl(BookRepository repo, BookMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public BookResponseDTO create(BookRequestDTO dto) {
        Book book = mapper.toEntity(dto);
        book.setAvailableCopies(dto.getTotalCopies()); // al crear, disponibles = totales
        return mapper.toDto(repo.save(book));
    }

    @Override
    public BookResponseDTO update(Long id, BookRequestDTO dto) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        mapper.updateFromDto(dto, book);
        return mapper.toDto(repo.save(book));
    }

    @Override
    public BookResponseDTO findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public List<BookResponseDTO> list() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        repo.deleteById(id);
    }
}


