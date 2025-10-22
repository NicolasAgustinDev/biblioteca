package com.example.library.controller;

import com.example.library.dto.request.BookRequestDTO;
import com.example.library.dto.response.BookResponseDTO;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookRequestDTO bookRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.create(bookRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> get(@PathVariable Long bookId) {
        return ResponseEntity.ok(this.bookService.findById(bookId));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> list() {
        return ResponseEntity.ok(this.bookService.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> update(@PathVariable Long bookId,
                                                  @Valid @RequestBody BookRequestDTO bookRequest) {
        return ResponseEntity.ok(bookService.update(bookId, bookRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }
}
