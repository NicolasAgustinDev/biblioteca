package com.example.library.service;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.entity.BookEntity;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookDto) {
        BookEntity bookEntity = bookMapper.toEntity(bookDto);
        BookEntity bookSaved = bookRepository.save(bookEntity);
        return bookMapper.toDTO(bookSaved);
    }

    @Override
    public BookResponseDTO updateBook(Long bookId, BookRequestDTO bookDto) {
        BookEntity existing = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        existing.setTitle(bookDto.getTitle());
        existing.setAuthor(bookDto.getAuthor());
        existing.setIsbn(bookDto.getIsbn());
        existing.setYear(bookDto.getYear());
        existing.setTotalCopies(bookDto.getTotalCopies());
        existing.setCategory(bookDto.getCategory());
        return bookMapper.toDTO(bookRepository.save(existing));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookResponseDTO getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }
}



