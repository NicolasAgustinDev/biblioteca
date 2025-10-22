package com.example.library.service;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.entity.BookEntity;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Override
    public BookResponseDTO create(BookRequestDTO bookDto) {
        BookEntity bookEntity = bookMapper.toEntity(bookDto);
        BookEntity bookSaved = bookRepository.save(bookEntity);
        return bookMapper.toDTO(bookSaved);
    }

    @Override
    public BookResponseDTO update(Long bookId, BookRequestDTO bookDto) {
        BookEntity existing = this.bookRepository.findById(bookId)
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
                .toList();
    }
}



